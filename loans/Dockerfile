FROM openjdk:17-slim as build
FROM maven:latest


MAINTAINER loans.com
COPY target/loans-0.0.1-SNAPSHOT.jar loans-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "/loans-0.0.1-SNAPSHOT.jar"]