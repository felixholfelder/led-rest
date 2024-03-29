FROM openjdk:17-alpine
ARG revision
ENV revision=$revision
EXPOSE 8080
COPY target/led-rest-${revision}.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
