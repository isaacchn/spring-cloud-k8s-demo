FROM openjdk:8-jdk-alpine
ARG JAR_FILE="target/cloud-k8s-mail-0.0.1-SNAPSHOT.jar"
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar","--spring.profiles.active=sit"]