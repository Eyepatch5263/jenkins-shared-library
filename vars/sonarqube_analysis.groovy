def call(String SonarQubeAPI, String Projectname, String ProjectKey){
  withSonarQubeEnv("${SonarQubeAPI}"){
    
      sh """
      cd /var/lib/jenkins/workspace/Codilio-CI/${Projectname}
      $SONAR_HOME/bin/sonar-scanner -Dsonar.projectName=${Projectname} -Dsonar.projectKey=${ProjectKey} -Dsonar.scm.provider=git -X
    """
  }
}
