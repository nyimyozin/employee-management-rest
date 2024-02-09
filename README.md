# REST Employee Project for Spring Boot
Welcome to the REST Employee Project! This project provides RESTful APIs for managing employee data using Spring Boot.

## Overview
The REST Employee Project is built using Spring Boot and integrates various dependencies to facilitate development, testing, and documentation of RESTful APIs for employee management.


## Dependencies

This project utilizes the following dependencies:

Spring Boot Starter JDBC: Provides support for JDBC database operations.
Spring Boot Starter Web: Enables building web applications using Spring MVC.
MyBatis Spring Boot Starter: Integrates MyBatis with Spring Boot for SQL mapping and database operations.
PostgreSQL: JDBC driver for PostgreSQL database.
Project Lombok: Helps reduce boilerplate code in Java classes.
Spring Boot Starter Tomcat: Embedded Apache Tomcat server for running the application.
Spring Boot Starter Test: Provides testing support for Spring Boot applications.
Spring Boot Starter Security: Adds security features to Spring Boot applications.
Spring Boot Starter Validation: Supports validation in Spring Boot applications.
Springfox Boot Starter: Generates Swagger documentation for APIs.
Prerequisites
Before running this project, make sure you have the following installed:

Java (version 1.8)
Maven (version 3.6.0 or higher)
PostgreSQL (version 9.6 or higher) or any other relational database
Getting Started
To get started with the REST Employee Project, follow the steps mentioned in the README file of the project repository.

## How to Get Started

To get started with the REST Employee Project, follow these steps:
1. Clone this repository to your local machine:
`git clone https://github.com/nyimyozin/employee-management-rest`

2. Navigate to the project directory:
`cd employee-rest`

3. Set up your PostgreSQL database and import the provided SQL file `employee_db.sql` into the database.
    
4.  Open the `application.properties` file located in the `src/main/resources` directory and configure your database connection details:
`spring.datasource.url=jdbc:postgresql://localhost:5432/employee_db`
`spring.datasource.username=your_username`
`spring.datasource.password=your_password`

5.  Replace `localhost:5432` with your database host and port, and `your_username` and `your_password` with your PostgreSQL username and password.
    
6.  Build the project using Maven:
`mvn clean install`

7. Run the project:
`mvn spring-boot:run`

Once the application is running, you can access the API documentation at http://localhost:8080/swagger-ui.html to see the available endpoints and interact with them.

## Configuration

You can configure additional settings in the application.properties file, such as database connection details, server port, etc.

## Contact

If you have any questions or suggestions regarding the REST Employee Project, feel free to contact me at nyimyozin04@gmail.com.