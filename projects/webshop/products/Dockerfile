FROM openjdk:17-alpine
ADD target/products-0.0.1-SNAPSHOT.jar /products.jar
RUN cd /
EXPOSE 8080
ENTRYPOINT ["java", "-jar",  "products.jar"]