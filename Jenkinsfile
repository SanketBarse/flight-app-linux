pipeline{

    agent any

    stages{

        stage('packaging'){
            steps{
                bat "mvn clean package -DskipTests"
            }
        }

        stage('building-docker-image'){
            steps{
                bat "docker build -t=sanket0414/selenium-docker-integration ."
            }
        }

        stage('pushing-docker-image'){
            bat "docker push sanket0414/selenium-docker-integration"
        }
    }

}