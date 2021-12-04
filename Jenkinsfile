pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh 'cd products-service && ./mvnw clean compile'
            }
        }
        stage('UnitTests') {
            steps {
                sh 'cd products-service && ./mvnw test -PUnitTests'
            }
        }
        stage('IntegrationTests') {
            steps {
                sh 'cd products-service && ./mvnw test -PIntegrationTests'
            }
        }
        stage('Package') {
            steps {
                sh 'cd products-service && ./mvnw package'
            }
        }
    }
}