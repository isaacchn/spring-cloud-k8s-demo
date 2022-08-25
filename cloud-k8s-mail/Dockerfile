FROM openjdk:8-jdk-alpine

WORKDIR /spring

COPY target/libs ./libs
COPY target/resources ./resources
COPY target/cloud-k8s-sms.jar ./

#ENTRYPOINT ["java","-jar","./cloud-k8s-mail.jar","--spring.profiles.active=sit"]
ENTRYPOINT ["java","${JAVA_AGENT_OPTS}","${JVM_OPTS}","-cp","*:libs/*:ldsk-libs/*:resource","me.isaac.demo.MailApplication","${SPRING_OPTS}"]