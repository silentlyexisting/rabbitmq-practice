FROM ubuntu

RUN apt update \
        && apt install openjdk-17-jdk -y

COPY target/producer-1.0-SNAPSHOT.jar .

ENTRYPOINT ["java", "-jar", "producer-1.0-SNAPSHOT.jar"]

EXPOSE 7000