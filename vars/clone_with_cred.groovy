def call(String Projectname, String branch ){
  withCredentials([usernamePassword(credentialsId: 'Github-Credentials', usernameVariable: 'GIT_USERNAME', passwordVariable: 'GIT_TOKEN')]) {
                
                sh """
                if [ -d "${Projectname}" ]; then
                        rm -rf ${Projectname}
                    fi
                    # Prevent leaking credentials
                    rm -f $HOME/.git-credentials

                    # Store credentials for this session
                    git config --global credential.helper 'store --file=$HOME/.git-credentials'

                    # Clone repository securely
                    git clone --branch main https://${GIT_USERNAME}:${GIT_TOKEN}@github.com/Eyepatch5263/codilio.git
                    # git clone --branch ${branch} https://github.com/eyepatch5263/${Projectname}.git

                    # Clean up credentials file after cloning
                    rm -f $HOME/.git-credentials
                """
            }
}
