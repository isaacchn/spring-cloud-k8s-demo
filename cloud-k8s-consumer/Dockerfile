FROM openjdk:8-jdk-alpine

WORKDIR /spring

COPY target/lib ./lib
COPY target/resources ./resources
COPY target/cloud-k8s-sms.jar ./

ENTRYPOINT ["java","-jar","./cloud-k8s-consumer.jar","--spring.profiles.active=sit"]
