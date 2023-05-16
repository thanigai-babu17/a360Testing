FROM maven:3.8.6-jdk-11

# # Firefox

# ARG FIREFOX_VERSION=105.0
# RUN apt-get update -qqy \
#     && apt-get -qqy install libgtk-3-0 libx11-xcb1 libdbus-glib-1-2 libxt6 libasound2 \
#     && rm -rf /var/lib/apt/lists/* /var/cache/apt/* \
#     && wget -q -O /tmp/firefox.tar.bz2 https://download-installer.cdn.mozilla.net/pub/firefox/releases/$FIREFOX_VERSION/linux-x86_64/en-US/firefox-$FIREFOX_VERSION.tar.bz2 \
#     && tar xjf /tmp/firefox.tar.bz2 -C /opt \
#     && rm /tmp/firefox.tar.bz2 \
#     && mv /opt/firefox /opt/firefox-$FIREFOX_VERSION \
#     && ln -s /opt/firefox-$FIREFOX_VERSION/firefox /usr/bin/firefox

# # Geckodriver

# ARG GECKODRIVER_VERSION=v0.33.0
# RUN wget -q -O /tmp/geckodriver.tar.gz https://github.com/mozilla/geckodriver/releases/download/$GECKODRIVER_VERSION/geckodriver-$GECKODRIVER_VERSION-linux64.tar.gz \
#     && tar xzf /tmp/geckodriver.tar.gz -C /opt \
#     && rm /tmp/geckodriver.tar.gz \
#     && mv /opt/geckodriver /opt/geckodriver-$GECKODRIVER_VERSION \
#     && ln -s /opt/geckodriver-$GECKODRIVER_VERSION /usr/bin/geckodriver

# Chrome

ARG CHROME_VERSION=94.0.4606.61
RUN apt-get update -qqy \
    && apt-get -qqy install wget \
    && wget -q -O /tmp/chrome.deb https://dl.google.com/linux/chrome/deb/pool/main/g/google-chrome-stable/google-chrome-stable_$CHROME_VERSION-1_amd64.deb \
    && dpkg -i /tmp/chrome.deb \
    && apt-get -qqy --fix-broken install \
    && rm /tmp/chrome.deb

# Chromedriver

ARG CHROMEDRIVER_VERSION=94.0.4606.61
RUN wget -q -O /tmp/chromedriver.zip https://chromedriver.storage.googleapis.com/$CHROMEDRIVER_VERSION/chromedriver_linux64.zip \
    && unzip /tmp/chromedriver.zip -d /opt \
    && rm /tmp/chromedriver.zip \
    && chmod +x /opt/chromedriver \
    && ln -s /opt/chromedriver /usr/bin/chromedriver

# Set the working directory
WORKDIR /app

# Copy the source code into the container
COPY . .

# # Set the custom path for GeckoDriver
# ENV PATH="/usr/src/app/Drivers/geckodriver.exe"

# # Change ownership and permissions of .m2 directory
# RUN mkdir -p /root/.m2 \
#     && chown -R root:root /root/.m2 \
#     && chmod -R 755 /root/.m2

# Run the tests with Firefox
CMD ["mvn", "test", "-Dbrowser=chrome"]

