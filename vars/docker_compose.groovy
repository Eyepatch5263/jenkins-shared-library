def call(){
  sh ''' cd codilio &&
  pwd &&
  docker compose up -d
  '''
  echo "Container started successfully."
}
