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
            }
        }
    }
}