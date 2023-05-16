FROM maven:3.8.6-jdk-11

# Install Chrome and dependencies
# RUN apt-get update -qqy \
#     && apt-get -qqy install wget gnupg \
#     && wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add - \
#     && echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google-chrome.list \
#     && apt-get update -qqy \
#     && apt-get -qqy install google-chrome-stable \
#     && rm -rf /var/lib/apt/lists/* /var/cache/apt/*

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

# Create the Drivers directory
RUN mkdir -p /app/Drivers/

# # Set ChromeDriver version
# ARG CHROME_DRIVER_VERSION=92.0.4515.107

# # Download and extract ChromeDriver
# RUN wget -q -O /tmp/chromedriver.zip https://chromedriver.storage.googleapis.com/$CHROME_DRIVER_VERSION/chromedriver_linux64.zip \
#     && unzip /tmp/chromedriver.zip -d /app/Drivers/ \
#     && rm /tmp/chromedriver.zip \
#     && chmod +x /app/Drivers/chromedriver

# Geckodriver

ARG GECKODRIVER_VERSION=v0.33.0
RUN wget -q -O /tmp/geckodriver.tar.gz https://github.com/mozilla/geckodriver/releases/download/$GECKODRIVER_VERSION/geckodriver-$GECKODRIVER_VERSION-linux64.tar.gz \
    && tar xzf /tmp/geckodriver.tar.gz -C /opt \
    && rm /tmp/geckodriver.tar.gz \
    && mv /tmp/geckodriver /app/Drivers/geckodriver-$GECKODRIVER_VERSION \
    && ln -s /opt/geckodriver-$GECKODRIVER_VERSION /usr/bin/geckodriver

# Set the working directory
WORKDIR /app

# Copy the source code into the container
COPY . .

# Verify if chromedriver file exists
RUN ls -la /app/Drivers/

# Run the tests with Chrome
CMD ["mvn", "test", "-Dbrowser=firefox"]
