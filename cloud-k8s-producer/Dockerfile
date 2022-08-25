FROM openjdk:8-jdk-alpine

WORKDIR /spring

COPY target/lib ./lib
COPY target/resources ./resources
COPY target/cloud-k8s-sms.jar ./

#ENTRYPOINT ["java","-jar","./cloud-k8s-producer.jar","--spring.profiles.active=sit"]
ENTRYPOINT ["java","${JAVA_AGENT_OPTS}","${JVM_OPTS}","-cp","*:libs/*:ldsk-libs/*:resource","me.isaac.demo.ProducerApplication","${SPRING_OPTS}"]