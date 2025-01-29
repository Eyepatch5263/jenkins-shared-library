def call(String url, String branch){
  withCredentials([usernamePassword(credentialsId: 'Github-Credentials', usernameVariable: 'GIT_USERNAME', passwordVariable: 'GIT_TOKEN')]) {
                    sh '''
                        # Clone using HTTPS with a PAT
                        git clone --branch ${branch} ${url}
                    '''
 echo "cloned the github repo sucessfully"
}
