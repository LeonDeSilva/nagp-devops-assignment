# NAGP DEVOPS Assignment

## TASK 3 - Jenkins File Creation

Please refer to the [Jenkinsfile](https://github.com/LeonDeSilva/nagp-devops-assignment/blob/build/Jenkinsfile)
for the pipeline steps

Plugins are listed out in  [JenkinsPluginsList.txt](https://github.com/LeonDeSilva/nagp-devops-assignment/blob/build/JenkinsPluginsList.txt)

### Jenkinsfile contains the following steps:
1. Trigger build if a code commit is detected. (Poll SCM is to check for changes)
2. Run Build, UnitTests, IntegrationTests and Package on builtin node
3. Copy the artifacts from built in node to the docker-agent node hosted in AWS EC2
4. Run docker build and push the docker image to dockerhub in docker-agent node

### DockerHub Repository where image is pushed:

https://hub.docker.com/repository/docker/leondesilva/product-service





