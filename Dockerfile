FROM openjdk:8-jdk-alpine
MAINTAINER Venkat Vallabhaneni <venkata.vallabhaneni@gmail.com>
ADD /parkingspotmgmt-app/target/parkingspotmgmt-app.jar parkingspotmgmt-app.jar
ENTRYPOINT ["java", "-jar", "/parkingspotmgmt-app.jar"]
EXPOSE 9080