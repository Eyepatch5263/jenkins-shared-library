def call(String SonarQubeAPI, String Projectname, String ProjectKey) {
    withSonarQubeEnv("${SonarQubeAPI}") {
        sh """
            ${SONAR_SCANNER_HOME}/bin/sonar-scanner \
            -Dsonar.projectName='${Projectname}' \
            -Dsonar.projectKey='${ProjectKey}' \
            -Dsonar.host.url='$SONAR_HOST_URL' \
            -X
        """
    }
}
