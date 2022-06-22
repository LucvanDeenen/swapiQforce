FROM openjdk:11-alpine
MAINTAINER LvanDeenen
COPY target/boulderApp-0.1.0-SNAPSHOT.jar boulderApp-0.1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/boulderApp-0.1.0-SNAPSHOT.jar"]