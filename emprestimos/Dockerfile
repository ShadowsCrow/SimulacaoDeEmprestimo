FROM openjdk:17-jdk-alpine
EXPOSE 8080
VOLUME /tmp
COPY target/emprestimos-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]