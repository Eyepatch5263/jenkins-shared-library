def call(){
  sh '''
  docker-compose down &&
  docker-compose up -d
  '''
  echo "Container started successfully."
}
