FROM openjdk:17.0-jdk-slim-bullseye
COPY "./target/spring-core-1.0-SNAPSHOT.jar" "/application/app.jar"
EXPOSE 8081
CMD ["java", "-jar", "/application/app.jar"]