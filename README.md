# NAGP Devops Assignment

## Task 1 - Create Web Service

Notes:
1. The Web service is a product service which runs on port 9000
2. The Web service uses postgres DB as the data store
3. There are several unit tests and integrations tests written
4. By default all tests are skipped for all phases
5. If need to run unit tests, we need to provide the UnitTests profile
6. If need to run integration tests, we need to provide the IntegrationTests profile

### Commands
Clean compile project via maven wrapper

`mvnw clean compile`

Run unit tests via maven wrapper

`mvnw test -PUnitTests`

Run integration tests via maven wrapper

`mvnw test -PIntegrationTests`

Build application artifact

`mvnw package`

Run application

    Pre-requisite: Postgres running on port 5432

`java -jar products-service-0.0.1-SNAPSHOT.jar`



### Endpoints exposed 

* Get all products
  
      HTTP METHOD: GET
      
      ENDPOINT: localhost:9000/products
  
* Get product for a given id

      HTTP METHOD: GET
      
      ENDPOINT: localhost:9000/products/{id}

* Add product

      HTTP METHOD: POST
      
      ENDPOINT: localhost:9000/products
      POST BODY: {
                      "id": "1",
                      "name": "p1",
                      "quantity": 10
                  }
  





