FROM openjdk:17-jdk-slim
EXPOSE 8080
WORKDIR /app
ADD target/hello-observability-0.0.1-SNAPSHOT.jar hello-observability-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "hello-observability-0.0.1-SNAPSHOT.jar"]