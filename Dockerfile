FROM openjdk:17-alpine
EXPOSE 9000
COPY target/led-rest-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
