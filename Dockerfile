FROM amazoncorretto:11-alpine-jdk
MAINTAINER WizardSustine
COPY target/BackEnd-0.0.1-SNAPSHOT.jar  backend-app.jar
ENTRYPOINT ["java","-jar","/backend-app.jar"]
