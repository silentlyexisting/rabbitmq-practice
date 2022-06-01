FROM ubuntu

RUN apt update \
        && apt install openjdk-17-jdk -y

COPY target/consumer-1.0-SNAPSHOT.jar .

ENTRYPOINT ["java", "-jar", "consumer-1.0-SNAPSHOT.jar"]

EXPOSE 7001