pipeline {
    agent any

    environment {
        IMAGE_NAME = "testuser/http-echo"
        IMAGE_TAG = "latest"
        DOCKERHUB_CREDENTIALS = "dockerhub-credentials"
    }

    stages {

        stage('Build and Push Docker Image') {
            steps {
                script {
                    dockerUtils.buildAndPushDockerImage(
                        IMAGE_NAME,
                        IMAGE_TAG,
                        DOCKERHUB_CREDENTIALS
                    )
                }
            }
        }

        stage('Run Container and Healthcheck') {
            steps {
                script {
                    sh """
                        docker run -d --name http-echo-test -p 5678:5678 ${IMAGE_NAME}:${IMAGE_TAG}
                        sleep 5
                        docker ps | grep http-echo-test
                        curl -f http://localhost:5678 || exit 1
                    """
                }
            }
        }
    }

    post {
        always {
            echo "Cleaning up containers and images..."
            sh """
                docker rm -f http-echo-test || true
                docker rmi ${IMAGE_NAME}:${IMAGE_TAG} || true
            """
        }
    }
}
