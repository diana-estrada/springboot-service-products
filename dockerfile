FROM openjdk:8
VOLUME /tmp
ADD springboot-service-products-0.0.1-SNAPSHOT.jar service-products.jar
ENTRYPOINT ["java", "-jar", "/service-products.jar"]