FROM openjdk:17-alpine
ADD target/cart-0.0.1-SNAPSHOT.jar /cart.jar
RUN cd /
EXPOSE 8080
ENTRYPOINT ["java", "-jar",  "cart.jar"]