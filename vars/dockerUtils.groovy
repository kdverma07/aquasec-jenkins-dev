def buildAndPushDockerImage(String imageName, String imageTag, String credentialsId) {
    withCredentials([usernamePassword(credentialsId: credentialsId, usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
        sh """
            echo "Building Docker image..."
            docker build -t ${imageName}:${imageTag} .
            
            echo "Logging in to Docker Hub..."
            echo "${DOCKER_PASS}" | docker login -u "${DOCKER_USER}" --password-stdin

            echo "Pushing Docker image..."
            docker push ${imageName}:${imageTag}
        """
    }
}
