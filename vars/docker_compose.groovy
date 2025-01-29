def call(String Projectname){
  sh '''
  cd ${Projectname} &&
            docker compose down &&
            docker compose up -d
  '''
  echo "Container started successfully."
}
