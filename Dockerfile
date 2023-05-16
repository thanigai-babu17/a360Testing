# Use a base image with your desired programming language and dependencies
FROM maven:3.8.1-jdk-11

# Set the working directory
WORKDIR /app

# Copy the necessary files to the container
COPY . .

# Build the Maven project
RUN mvn clean install

# Set the entry point command to run Cucumber
CMD ["mvn", "test"]
