def call(String projectName, String ImageTag, String DockerhubUser){
 sh """
                docker build -t ${DockerhubUser}/${projectName}:${ImageTag} .
                echo "Built a Docker image successfully."
            """

}
