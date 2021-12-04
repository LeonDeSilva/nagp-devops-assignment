pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }
        stage('UnitTests') {
            steps {
                sh 'mvn test -PUnitTests'
            }
        }
        stage('IntegrationTests') {
            steps {
                sh 'mvn test -PIntegrationTests'
            }
        }
        stage('Package') {
            steps {
                sh 'mvn package'
            }
        }
    }
}