def call(String Projectname, String branch) {
    withCredentials([usernamePassword(credentialsId: 'Github-Credentials', usernameVariable: 'GIT_USERNAME', passwordVariable: 'GIT_TOKEN')]) {
        sh """
            if [ -d '${Projectname}' ]; then
                rm -rf '${Projectname}'
            fi

            # Clone the repository
            git clone --branch '${branch}' https://\${GIT_USERNAME}:\${GIT_TOKEN}@github.com/Eyepatch5263/${Projectname}.git

            cd ${Projectname}
            npm install --legacy-peer-deps
        """
    }
}
