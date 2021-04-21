
FROM openjdk:12-jdk-alpine

RUN addgroup -S spring && adduser -S spring -G spring

USER spring:spring

WORKDIR /home/spring

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} ~/app.jar

ENTRYPOINT ["java","-Dspring.profiles.active=prod","-jar","~/app.jar"]

# ENTRYPOINT ["java","-Xmx512m","-Dserver.port=${PORT}","-jar","~/app.jar"]


