FROM openjdk:21-jdk-slim
COPY target/app-0.1.jar /app.jar
CMD ["java", "-jar", "/app.jar"]