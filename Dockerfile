FROM openjdk:11
VOLUME /tmp
EXPOSE 8081
ARG JAR_FILE=target/spring-boot-crud.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]