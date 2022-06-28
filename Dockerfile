FROM openjdk:11
MAINTAINER LvanDeenen
ARG JAR_FILE=build/libs/swapiQforce-1.0.0-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
