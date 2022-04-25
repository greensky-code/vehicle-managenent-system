FROM openjdk:14-jdk-alpine
LABEL maintainer="tanmoy.dasgupta1993@gmail.com"
VOLUME /main-app
ADD build/libs/vehicle-management-system-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar","/app.jar"]