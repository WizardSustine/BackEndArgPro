FROM amazoncorretto:11
MAINTAINER WizardSustine
COPY target/BackEnd-0.0.1-SNAPSHOT.jar  backend-app.jar
ENTRYPOINT ["java","-jar","/backend-app.jar"]
