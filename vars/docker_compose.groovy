def call(String Projectname){
  sh '''
  cd ${Projectname} &&
  pwd &&
            docker compose down &&
            docker compose up -d
  '''
  echo "Container started successfully."
}
