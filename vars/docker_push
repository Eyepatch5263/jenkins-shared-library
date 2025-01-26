def call(String Project, String Imagetag, String dockerhubUser) {
    withCredentials([usernamePassword(
        credentialsId: "dockerCred", 
        passwordVariable: "dockerhubPass",
        usernameVariable: "dockerhubUser"
    )]) {
        sh "docker login -u ${dockerhubUser} -p ${dockerhubPass}"
    }
    sh "docker push ${dockerhubUser}/${Project}:${Imagetag}"
    echo "Pushed the image to Docker Hub"
}
