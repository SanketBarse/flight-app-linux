pipeline{

    agent none

    stages{

        stage('packaging'){
            agent{
                docker{
                    image 'maven:3-eclipse-temurin-21-alpine'

                }
            }
            steps{

                sh "mvn clean package -DskipTests"
            }
        }

        stage('building-docker-image'){
            steps{
                bat "docker build -t=sanket0414/selenium-docker-integration ."
            }
        }

        stage('pushing-docker-image'){
            environment{
                DOCKER_HUB = credentials("DOCKER_HUB_CRED")
            }
            steps{
                bat 'docker login -u ${DOCKER_HUB_USR}" -p ${DOCKER_HUB_PSW'
                bat "docker push sanket0414/selenium-docker-integration"
            }
        }
    }

    post{
        always {
            bat "docker logout"
        }
    }

}