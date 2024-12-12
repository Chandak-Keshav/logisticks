# Use a Java runtime image
FROM openjdk:17-jdk-slim
WORKDIR /app
# Copy and build the JAR
COPY build.gradle .
COPY src ./src
COPY build/libs/logisticks-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8088
# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
