A retailer offers a rewards program to its customers, awarding points based on each recorded purchase.
A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every
dollar spent over $50 in each transaction
(e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points).

Requirements
The fully fledged server uses the following:

Spring Framework
SpringBoot
A CloudFoundry account (to deploy the server)
Dependencies
There are a number of third-party dependencies used in the project. Browse the Maven pom.xml file for details of libraries and versions used.

Building the project
You will need:

Java JDK 8 or higher
Maven 3.1.1 or higher
Git
Clone the project and use Maven to build the server

$ mvn clean install

Running the application locally
There are several ways to run a Spring Boot application on your local machine. One way is to execute the main method in the de.codecentric.springbootsample.Application class from your IDE.

Alternatively you can use the Spring Boot Maven plugin like so:

mvn spring-boot:run

local url:

http://localhost:8080/rewards/{custId}

working url :
http://localhost:8080/rewards/1001