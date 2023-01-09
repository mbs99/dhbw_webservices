FROM openjdk:17-alpine
ADD target/products-0.0.1-SNAPSHOT.jar /products.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar",  "/products.jar"]