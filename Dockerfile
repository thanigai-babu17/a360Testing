# # Use a base image with your desired programming language and dependencies
# FROM maven:3.8.1-jdk-11

# # Set the working directory
# WORKDIR /app

# # Copy the necessary files to the container
# COPY . .

# # Build the Maven project
# RUN mvn clean install


FROM selenium/standalone-firefox

# Set the working directory
WORKDIR /usr/src/app

# Copy your application files to the container
COPY . .

# Install necessary dependencies
USER root
RUN apt-get update \
    && apt-get install -y --no-install-recommends openjdk-11-jdk maven \
    && rm -rf /var/lib/apt/lists/* \
    && mkdir -p /var/lib/apt/lists/partial \
    && apt-get clean \
    && apt-get autoclean
RUN chown -R seluser:seluser /usr/src/app

USER seluser

# Set the PATH to include GeckoDriver
ENV PATH="/usr/src/app/Drivers/geckodriver.exe"

# Build and run your tests
RUN mvn clean install
RUN mvn clean test

