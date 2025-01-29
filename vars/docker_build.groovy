def call(String projectName, String ImageTag, String DockerhubUser){
  echo "Built a docker Image Sucessfully."
  sh '''
          # Enable BuildKit
            export DOCKER_BUILDKIT=1
                
            # Build Docker image using BuildKit
            docker build -t ${DockerhubUser}/${projectName}:${ImageTag} .
            '''
}
