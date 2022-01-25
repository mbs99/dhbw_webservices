FROM openjdk:11
ADD target/docker-test-0.0.1-SNAPSHOT.jar /
RUN cd /
EXPOSE 8080
ENTRYPOINT ["java", "-jar",  "docker-test-0.0.1-SNAPSHOT.jar"]