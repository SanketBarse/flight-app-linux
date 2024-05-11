pipeline {
    agent none

    stages {
        stage('packaging') {
            agent {
                docker {
                    image 'maven:ibmjava'
                    args '-u root -v ${pwd}/tmp/m2:/root/.m2'
                }
            }
            steps {
                sh "mvn clean package -DskipTests"
            }
        }

        stage('building-docker-image') {
            steps {
                script{
                    app = docker.build('sanket0414/selenium-docker-integration')
                }
            }
        }

        stage('pushing-docker-image') {
            steps {
                script{
                    docker.withRegistry('', 'DOCKER_HUB_CRED') {
                    app.push('latest')
                    }
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