FROM adoptopenjdk/openjdk11:alpine
RUN mkdir /app
COPY target/echoserver-0.0.1-SNAPSHOT.jar /app/echoserver.jar
WORKDIR /app
EXPOSE 8080
CMD ["java", "-jar", "/app/echoserver.jar"]
