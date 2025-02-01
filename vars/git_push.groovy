def call(String Project, String branch) {
    withCredentials([usernamePassword(credentialsId: 'Github-Credentials', 
                                      usernameVariable: 'GIT_USERNAME', 
                                      passwordVariable: 'GIT_TOKEN')]) {
        sh """
            echo "Checking repository status:"
            git status
            echo "Configuring Git user:"
            git config --global user.email "pratyushpragyey.com"
            git config --global user.name "Eyepatch5263"

            echo "Adding changes to Git:"
            git add .

            echo "Committing changes:"
            git commit -m "Updated environment variables" || echo "No changes to commit"

            echo "Pushing changes to GitHub:"
            git push https://${GIT_USERNAME}:${GIT_TOKEN}@github.com/${GIT_USERNAME}/${Project}.git ${branch}
        """
    }
}
