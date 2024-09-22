FROM amazoncorreto:17-alpine-jdk
MAINTAINER MARCOS
COPY target/TripBundle-0.0.1-SNAPSHOT.jar TripBundle.jar
ENTRYPOINT ["java","-jar","/TripBundle.jar"]