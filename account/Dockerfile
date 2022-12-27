FROM openjdk:17-jdk-alpine
FROM maven:latest

MAINTAINER  account.com
COPY target/account-0.0.1-SNAPSHOT.jar account-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "/account-0.0.1-SNAPSHOT.jar"]