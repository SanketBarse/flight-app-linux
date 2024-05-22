pipeline {
    agent any
    stages {
        stage('packaging') {

            agent{
                docker{
                    image 'maven:3.9.6-sapmachine-21'
                    args '-u root -v /var/lib/jenkins/workspace/docker-selenium/target:/root/.m2'
                }
            }

            steps {
                sh "mvn clean package -DskipTests"
            }
        }

        stage('building-docker-image'){
            steps {
                script{
                    app = docker.build('sanket0414/selenium-docker-integration' , "-f ${pwd}/workspace/docker-selenium/Dockerfile .")
                }
            }
        }

        stage('pushing-docker-image') {
            steps {
                script{
                    docker.withRegistry('', 'DOCKER_HUB_CRED') {
                    app.push('linux')
                    }
                }
            }
        }
}

}