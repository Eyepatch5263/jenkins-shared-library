def call(String url, String branch){
  git url: "${url}", branch: "${branch}"
  echo "cloned the github repo sucessfully"
}
