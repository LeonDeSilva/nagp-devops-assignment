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
                zip zipFile: 'artifact.zip', archive: false, dir: 'products-service'
                archiveArtifacts artifacts: 'test.zip', fingerprint: true
            }
        }
        stage('Dockerize') {
            steps {
                node('docker-agent') {
                    script {
                        dockerImage = docker.build('leondesilva/product-service:v1', '-f products-service/DockerFile .')
                        copyArtifacts filter: 'artifact.zip', fingerprintArtifacts: true, projectName: '${JOB_NAME}', selector: specific('${BUILD_NUMBER}')
                                        unzip zipFile: 'artifact.zip', dir: './products-service'
                        docker.withRegistry('', DockerHubCredentials)
                            dockerImage.push("v2")
                    }
                }
            }
        }
    }
}