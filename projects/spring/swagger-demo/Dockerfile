FROM maven:3-eclipse-temurin-21 as builder
RUN mkdir /app
COPY src /app/src
COPY pom.xml /app
WORKDIR /app
RUN mvn clean package
FROM eclipse-temurin:21
RUN mkdir /app
COPY --from=builder /app/target/openapi-0.0.1-SNAPSHOT.jar /app/openapi.jar
EXPOSE 8080
CMD ["java", "-jar", "/app/openapi.jar"]
