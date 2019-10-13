# Perched Peacock Parking Lot Solutions

PerchedPeacock is a global parking solution company, manages vehicle parking across continents. A java based simple software with REST API service and swagger documentation as backend and Angular for User Interface

## Getting Started

Download the code from git repository and setup maven project in eclipse/intellij, uses the below technologies
1. spring boot 2
2. Spring Oauth2
3. Docker for containerization
4. Jenkins standalone war for CI/CD pipeline which is part of the code base under the root folder ,needs to be launched  and create a pipeline with jenkins file from the code repository as source.
5. Cucumber 
6.Postgres SQL
7. Mapstruct for bean copy
8. Swagger documentation of REST API
9. Lombok , must be initialized based on the IDE used , for intellij please download the plugin and for eclipse double click on lombok jar and chose the eclipse executable.
10. Angular 7 for User interface 

See Installing section for more information

### Prerequisites

1. JDK 8
2. an IDE
3. Docker for desktop
4. Postgres SQL
5. Jenkins on desktop or as a Web with pipeline 
6. Postman for Testing or Curl 



### Installing and running the application

1. setup project in IntelliJ /Eclipse IDE as maven project ( maven multi module project)
2. Compile the source with JDK8
3. Launch the Springboot Application from IDE (no profile exists)
4. Launch the Rest API/Swagger documentation URL in web http://localhost:9080/parkingspotmgmt/swagger-ui.html
5. use postman to test the Rest API and get the access token using below curl command with the desired scopes
curl -X POST -d "client_id=psmgmtclientid&client_secret=psmtgmtclientsecret&grant_type=client_credentials" http://localhost:9080/parkingspotmgmt/oauth/token

6. Supply the proper authentication bearer tokens and use the rest end points

## Running the tests

Can run the tests from IDE or using Jenkins pipeline, have Unit test as well as Integration Tests



## Deployment

Build the Jar using mvn clean install, copy the executable Jar  parkingspotmgmt-app-0.1-SNAPSHOT.jar and launch it as Jar (java -jar parkingspotmgmt-app-0.1-SNAPSHOT.jar), the application will run with default profile and embedded tomact on port 9080.

url to test : http://localhost:9080/parkingspotmgmt/swagger-ui.html

Can be deployed on docker platform too.

build the docker image and push it to your organization eg.
	
	docker build -t vallabhaneni1982/parkingspotmgmt-app .
	
Push the docker image
	docker push vallabhaneni1982/parkingspotmgmt-app:latest
	
Up the containers/service

docker-compose up -d
	
## Built With

* [Maven](https://maven.apache.org/) - Dependency Management



## Authors

Venkat Vallabhaneni

## License

NA

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc
