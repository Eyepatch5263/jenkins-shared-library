def call(String url, String branch){
sh "git clone --branch ${branch} ${url}"
 echo "cloned the github repo sucessfully"
}
