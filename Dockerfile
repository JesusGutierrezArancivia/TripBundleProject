FROM openjdk:17-alpine
MAINTAINER Jesus
COPY target/TripBundle-0.0.1-SNAPSHOT.jar TripBundle.jar
ENTRYPOINT ["java","-jar","/TripBundle.jar"]