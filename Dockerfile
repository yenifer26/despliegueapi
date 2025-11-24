FROM amazoncorretto:17-alpine-jdk
LABEL authors="JENNI"
COPY target/FinalElectiva-0.0.1-SNAPSHOT.jar /miapi-v1.jar

ENTRYPOINT ["java", "-jar","/miapi-v1.jar"]