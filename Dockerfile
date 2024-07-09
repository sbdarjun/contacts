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
COPY --from=build /app/target/*.jar /app.jar

# Copy the wait-for-it.sh script
COPY wait-for-it.sh /wait-for-it.sh

# Make the script executable
RUN chmod +x /wait-for-it.sh

#Server: sql3.freemysqlhosting.net
#Name: sql3718964
#Username: sql3718964
#Password: Xk9zIwxMMF
#Port number: 3306

ENV SPRING_DATASOURCE_URL=jdbc:mysql://sql3.freemysqlhosting.net/sql3718964
ENV SPRING_DATASOURCE_USERNAME=sql3718964
ENV SPRING_DATASOURCE_PASSWORD=Xk9zIwxMMF

# Expose the port the app runs on
EXPOSE 80

# Run the application
#ENTRYPOINT ["/wait-for-it.sh", "db:3306", "--", "java", "-jar", "/app.jar"]
ENTRYPOINT ["java", "-jar", "/app.jar"]