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
RUN sudo apt-get update && apt-get install -y openjdk-11-jdk maven

# Set the PATH to include GeckoDriver
ENV PATH="/usr/src/app/Driver:${PATH}"

# Build and run your tests
RUN mvn clean test

