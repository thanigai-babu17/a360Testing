FROM maven:3.8.6-jdk-11

# Install Chrome and dependencies
RUN apt-get update -qqy \
    && apt-get -qqy install wget gnupg \
    && wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add - \
    && echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google-chrome.list \
    && apt-get update -qqy \
    && apt-get -qqy install google-chrome-stable \
    && rm -rf /var/lib/apt/lists/* /var/cache/apt/*

# Set ChromeDriver version
ARG CHROME_DRIVER_VERSION=92.0.4515.107

# Download and install ChromeDriver
RUN wget -q -O /tmp/chromedriver.zip https://chromedriver.storage.googleapis.com/$CHROME_DRIVER_VERSION/chromedriver_linux64.zip \
    && unzip /tmp/chromedriver.zip -d /usr/local/bin/ \
    && rm /tmp/chromedriver.zip \
    && chmod +x /usr/local/bin/chromedriver

# Set the working directory
WORKDIR /app

# Copy the source code into the container
COPY . .

# Run the tests with Chrome
CMD ["mvn", "test", "-Dbrowser=chrome"]