# Step 1: Build the Java application using Maven
FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

# Step 2: Run the built JAR file using a lightweight OpenJDK runtime
FROM openjdk:17-jdk-slim
COPY --from=build /target/app-1.0.0.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]