# Use an official Maven image to build the app
FROM maven:3.8.6-eclipse-temurin-17 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml file and the source code
COPY pom.xml .
COPY src ./src

# Package the application
RUN mvn clean package -DskipTests

# Use an official JDK runtime image as a parent image
FROM openjdk:17-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the packaged jar file from the build stage
COPY --from=build /app/target/*.jar app/app.jar

# Copy the wait-for-it.sh script
COPY wait-for-it.sh /wait-for-it.sh

# Make the script executable
RUN chmod +x /wait-for-it.sh

# Expose the port the app runs on
EXPOSE 8080


# Run the application
ENTRYPOINT ["/wait-for-it.sh", "db:3306", "--", "java", "-jar", "/app.jar"]