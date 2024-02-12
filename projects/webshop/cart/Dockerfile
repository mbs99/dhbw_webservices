FROM maven:3.9.6-eclipse-temurin-21 as build
WORKDIR /app
ADD pom.xml .
ADD src src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jre
COPY --from=build /app/target/cart-0.0.1-SNAPSHOT.jar application.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "application.jar"]