pipeline {
    agent any
    triggers {
        pollSCM('*/1 * * * *')
    }
    stages {
        stage('Build') {
            steps {
                sh "chmod +x -R ${env.WORKSPACE}"
                sh 'cd products-service && ./mvnw clean compile'
            }
        }
        stage('UnitTests') {
            steps {
                sh "chmod +x -R ${env.WORKSPACE}"
                sh 'cd products-service && ./mvnw test -PUnitTests'
            }
        }
        stage('IntegrationTests') {
            steps {
                sh "chmod +x -R ${env.WORKSPACE}"
                sh 'cd products-service && ./mvnw test -PIntegrationTests'
            }
        }
        stage('Package') {
            steps {
                sh "chmod +x -R ${env.WORKSPACE}"
                sh 'cd products-service && ./mvnw package'
                stash 'products-service'
            }
        }
        stage('Dockerize') {
            steps {
                node('docker-agent') {
                    script {
                        unstash 'products-service'
                        dockerImage = docker.build('leondesilva/product-service:v1', '-f products-service/DockerFile .')
                        docker.withRegistry('', DockerHubCredentials)
                            dockerImage.push("v2")
                    }
                }
            }
        }
    }
}