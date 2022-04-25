# Welcome to Electric Vehical management project

## Pre requisites
Java 14
Maven 3.3.x
PostGreSql running instance

## Postgres Instance Configuration
Setup pgAdmin 4 and postgreSQL 10 in local system

```
spring.datasource.url=jdbc:postgresql://localhost:5432/vehicle-management
spring.datasource.username= lendux
spring.datasource.password= lendux

# The SQL dialect makes Hibernate generate better SQL for the chosen database
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQLDialect

# Hibernate ddl auto (create, create-drop, validate, update)
spring.jpa.hibernate.ddl-auto = update

```

## Run Application Locally
```mvn spring-boot:run```

## Run Integration Tests
```mvn test```

## Load Sample Data
schema and data are initialized using ```data.sql```

## Invoke Application

### Add a Company
```curl -X POST "localhost:8080/v1/app/company"```
running the above POST request will result to an 200 Ok HTTP response and JSON Content-Type of Application/json of the new created object and add a company

### Add a Station
```curl -X POST "localhost:8080/v1/app/station"```
running the above POST request will result to an 200 Ok HTTP response and JSON Content-Type of Application/json of the new created object and add a station

### Get all Station
```curl -X GET "localhost:8080/v1/app/stations"```
running the above GET request will result to an 200 Ok HTTP response and JSON Content-Type of Application/json and get all station.

### Get all companies
```curl -X GET "localhost:8080/v1/app/companies"```
running the above GET request will result to an 200 Ok HTTP response and JSON Content-Type of Application/json and get all companies.

### Update a company
```curl -X PUT "localhost:8080/v1/app/company/1"```
running the above PUT request will result to an 200 Ok HTTP response and JSON Content-Type of Application/json, update existing company.

### Update a station
```curl -X PUT "localhost:8080/v1/app/station/1"```
running the above PUT request will result to an 200 Ok HTTP response and JSON Content-Type of Application/json, update existing station.

### Delete a Station
```curl -X DELETE "localhost:8080/v1/app/station/1"```	
running the above DELETE request will result to an 200 Ok HTTP response and JSON Content-Type of Application/json, and delete a company.

### Delete a Company
```curl -X DELETE "localhost:8080/v1/app/company/1"```
running the above DELETE request will result to an 200 Ok HTTP response and JSON Content-Type of Application/json, and delete a company.


### Get all station within a radius from current location
```curl GET "localhost:8080/stations/{radius}/{lat}/{lon}"```
running the above GET request will result to an 200 Ok HTTP response and JSON Content-Type of Application/json, and get list of all station within given radius from current location
