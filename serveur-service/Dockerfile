FROM  openjdk:11
EXPOSE 8083
ADD /target/reservation-service-0.0.1-SNAPSHOT.jar reservation-service.jar
ENTRYPOINT ["java", "-jar", "reservation-service.jar"]