def call(){
  withCredentials([gitUsernamePassword(credentialsId: 'Github-Credentials', gitToolName: 'Default')]) {
                        sh '''
                        echo "Checking repository status: "
                        git status
                    
                        echo "Adding changes to git: "
                        git add .
                        
                        echo "Commiting changes: "
                        git commit -m "Updated environment variables"
                        
                        echo "Pushing changes to github: "
                        git push https://github.com/LondheShubham153/Wanderlust-Mega-Project.git main
                    '''
  }
}
