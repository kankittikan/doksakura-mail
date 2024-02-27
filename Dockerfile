FROM openjdk:17-jdk-slim
COPY target/doksakura-mail-0.0.1-SNAPSHOT.jar run.jar

ENTRYPOINT ["java","-jar","./run.jar"]