FROM maven:3.8.7-eclipse-temurin-17 as build
WORKDIR /app
ADD pom.xml .
ADD src src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jre
COPY --from=build /app/target/cart-0.0.1-SNAPSHOT.jar application.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "application.jar"]