pipeline {
    agent none
    stages {
        stage('packaging') {
            agent {
                docker {
                    image 'sanket0414/maven'
                    args '-u root -v /tmp/m2:/root/.m2 /workspace'
                }
            }
            steps {
                sh "mvn clean package -DskipTests"
            }
        }

        // stage('building-docker-image') {
        //     steps {
        //         script{
        //             app = docker.build('sanket0414/selenium-docker-integration' , "-f ${WORKSPACE}/Dockerfile .")
        //         }
        //     }
        // }

        // stage('pushing-docker-image') {
        //     steps {
        //         script{
        //             docker.withRegistry('', 'DOCKER_HUB_CRED') {
        //             app.push('latest')
        //             }
        //         }
        //     }
        // }
}

}