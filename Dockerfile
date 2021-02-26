FROM openjdk:8-jdk-alpine
COPY target/AcademicClassRegistration-0.0.1-SNAPSHOT.jar AcademicClassRegistration-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/AcademicClassRegistration-0.0.1-SNAPSHOT.jar"]