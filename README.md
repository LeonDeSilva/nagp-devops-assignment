# NAGP DEVOPS Assignment

## TASK 2 - Docker container creation

### Step 1 - Postgres Container

Pull Docker Image from docker hub

`docker pull postgres`

Run docker container for postgres

`docker run --name mypostgresdb -e POSTGRES_PASSWORD=12345678 -d postgres`

### Step 2 - Product Service Container

Pre-requisite: Build the Jar for product service

`mvnw clean compile package`


Build docker image for product service

`docker build -t "product-service" -f "DockerFile" .`

Run docker container for product service

`docker run -p 9000:9000 product-service`


