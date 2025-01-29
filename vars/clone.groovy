def call(String url, String branch){
  withCredentials([usernamePassword(credentialsId: 'Github-Credentials', usernameVariable: 'GIT_USERNAME', passwordVariable: 'GIT_TOKEN')]) {
                    sh '''
                        # Clone using HTTPS with a PAT
                       git clone --branch ${branch} https://$GIT_USERNAME:$GIT_TOKEN@github.com/eyepatch5263/codilio.git
  '''
  }
 echo "cloned the github repo sucessfully"
}
