// def call(String SonarQubeAPI, String Projectname, String ProjectKey) {
//     echo "Starting SonarQube Analysis..."
    
//     withSonarQubeEnv("${SonarQubeAPI}") {
//         sh 'echo "SonarQube Server: $SONAR_HOST_URL"'
        
//         sh """
//             ${SONAR_SCANNER_HOME}/bin/sonar-scanner \\
//             -Dsonar.projectName="${Projectname}" \\
//             -Dsonar.projectKey="${ProjectKey}" \\
//             -Dsonar.host.url="${SonarQubeAPI}" \\
//             -X
//         """
//     }
    
//     echo "SonarQube Analysis Completed!"
// }

def call(String SonarQubeAPI, String Projectname, String ProjectKey) {
    withSonarQubeEnv("${SonarQubeAPI}") {
        withCredentials([string(credentialsId: 'SonarQube', variable: 'SONAR_TOKEN')]) {
            sh '''
                ${SONAR_HOME}/bin/sonar-scanner \
                -Dsonar.projectName=${Projectname} \
                -Dsonar.projectKey=${ProjectKey} \
                -Dsonar.login=${SONAR_TOKEN} \
                -X
            '''
        }
    }
}

