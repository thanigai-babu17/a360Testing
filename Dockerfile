FROM maven:3.8.6-jdk-11

# Firefox

# RUN apt-get update && apt-get install -y \
#     xvfb \
#     xauth \
#     x11vnc \
#     libgtk-3-0 \
#     libasound2 \
#     libxtst6 \
#     libxss1 \
#     libgconf-2-4 \
#     libnss3 \
#     libatk-bridge2.0-0 \
#     libgtk-3-0 \
#     libx11-xcb1 \
#     libdbus-glib-1-2

# COPY start-xvfb.sh /usr/local/bin/
# RUN chmod +x /usr/local/bin/start-xvfb.sh

# #!/bin/bash
# Xvfb :99 -screen 0 1024x768x24 -ac +extension RANDR +extension RENDER -noreset &
# export DISPLAY=:99
# exec "$@"


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

# # Google Chrome

# ARG CHROME_VERSION=112.0.5615.49-1
# RUN apt-get update -qqy \
#     && apt-get -qqy install gpg unzip \
#     && wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add - \
#     && echo "deb http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google-chrome.list \
#     && apt-get update -qqy \
#     && apt-get -qqy install google-chrome-stable=$CHROME_VERSION \
#     && rm /etc/apt/sources.list.d/google-chrome.list \
#     && rm -rf /var/lib/apt/lists/* /var/cache/apt/* \
#     && sed -i 's/"$HERE\/chrome"/"$HERE\/chrome" --no-sandbox/g' /opt/google/chrome/google-chrome

# # ChromeDriver

# ARG CHROME_DRIVER_VERSION=112.0.5615.49
# RUN wget -q -O /tmp/chromedriver.zip https://chromedriver.storage.googleapis.com/$CHROME_DRIVER_VERSION/chromedriver_linux64.zip \
#     && unzip /tmp/chromedriver.zip -d /opt \
#     && rm /tmp/chromedriver.zip \
#     && mv /opt/chromedriver /opt/chromedriver-$CHROME_DRIVER_VERSION \
#     && chmod 755 /opt/chromedriver-$CHROME_DRIVER_VERSION \
#     && ln -s /opt/chromedriver-$CHROME_DRIVER_VERSION /usr/bin/chromedriver

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

COPY start-xvfb.sh /usr/local/bin/
RUN chmod +x /usr/local/bin/start-xvfb.sh

#!/bin/bash
RUN Xvfb :99 -screen 0 1024x768x24 -ac +extension RANDR +extension RENDER -noreset &
RUN export DISPLAY=:99
RUN exec "$@"


# Run the tests with Firefox
CMD ["start-xvfb.sh","mvn", "-X","test", "-Dbrowser=firefox"]

