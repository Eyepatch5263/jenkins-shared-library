def call(String Projectname, String branch) {
    withCredentials([usernamePassword(credentialsId: 'Github-Credentials', usernameVariable: 'GIT_USERNAME', passwordVariable: 'GIT_TOKEN')]) {
        sh '''
            if [ -d "$Projectname" ]; then
                rm -rf "$Projectname"
            fi

            # Configure git credentials
            git config --global credential.helper store --file=/var/lib/jenkins/.git-credentials
            echo "https://${GIT_USERNAME}:$GIT_TOKEN@github.com" > /var/lib/jenkins/.git-credentials

            # Clone the repository
            git clone --branch $branch https://github.com/Eyepatch5263/codilio.git

            # Clean up credentials
            rm -f /var/lib/jenkins/.git-credentials
        '''
    }
}
