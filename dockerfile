FROM openjdk:8-jdk-alpine
COPY target/subnet-0.0.1-SNAPSHOT.jar subnet-0.0.1.jar
ENTRYPOINT ["java","-jar","/subnet-0.0.1.jar"]