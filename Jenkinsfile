pipeline {
    agent none

    environment {
        DOCKER_IMAGE = 'maven:3-eclipse-temurin-21-alpine'
        DOCKER_HUB_CRED = credentials('DOCKER_HUB_CRED')
        DOCKER_HUB_USR = DOCKER_HUB_CRED_USR
        DOCKER_HUB_PSW = DOCKER_HUB_CRED_PSW
    }

    stages {
        stage('packaging') {
            agent {
                docker {
                    image DOCKER_IMAGE
                    args '-u root -v /tmp/m2:/root/.m2'
                }
            }
            steps {
                sh "mvn clean package -DskipTests"
            }
        }

        stage('building-docker-image') {
            steps {
                bat "docker build -t sanket0414/selenium-docker-integration ."
            }
        }

        stage('pushing-docker-image') {
            steps {
                docker.withRegistry('', DOCKER_HUB_CRED) {
                    docker.image('sanket0414/selenium-docker-integration').push()
                }
            }
        }
    }

    post {
        always {
            bat "docker logout"
        }
    }
}