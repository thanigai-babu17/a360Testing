FROM maven:3.8.6-jdk-11

ARG FIREFOX_VERSION=105.0
RUN apt-get update -qqy \
    && apt-get -qqy install libgtk-3-0 libx11-xcb1 libdbus-glib-1-2 libxt6 libasound2 \
    xvfb \
    xauth \
    x11vnc \
    libxtst6 \
    libxss1 \
    libgconf-2-4 \
    libnss3 \
    libatk-bridge2.0-0 \
    libdbus-glib-1-2 \
    && rm -rf /var/lib/apt/lists/* /var/cache/apt/* \
    && wget -q -O /tmp/firefox.tar.bz2 https://download-installer.cdn.mozilla.net/pub/firefox/releases/$FIREFOX_VERSION/linux-x86_64/en-US/firefox-$FIREFOX_VERSION.tar.bz2 \
    && tar xjf /tmp/firefox.tar.bz2 -C /opt \
    && rm /tmp/firefox.tar.bz2 \
    && mv /opt/firefox /opt/firefox-$FIREFOX_VERSION \
    && ln -s /opt/firefox-$FIREFOX_VERSION/firefox /usr/bin/firefox

# Geckodriver
ARG GECKODRIVER_VERSION=v0.33.0
RUN wget -q -O /tmp/geckodriver.tar.gz https://github.com/mozilla/geckodriver/releases/download/$GECKODRIVER_VERSION/geckodriver-$GECKODRIVER_VERSION-linux64.tar.gz \
    && tar xzf /tmp/geckodriver.tar.gz -C /opt \
    && rm /tmp/geckodriver.tar.gz \
    && mv /opt/geckodriver /opt/geckodriver-$GECKODRIVER_VERSION \
    && ln -s /opt/geckodriver-$GECKODRIVER_VERSION /usr/bin/geckodriver

# Set the working directory
WORKDIR /app

# Copy the source code into the container
COPY . .

# Set the display and provide executable permissions to run.sh
# ENV DISPLAY :99
# RUN chmod +x run.sh

# Run the tests with Firefox using Xvfb
CMD mvn -X test
