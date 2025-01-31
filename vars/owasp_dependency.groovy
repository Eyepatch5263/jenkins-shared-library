def call() {
    script {
        echo "Starting OWASP Dependency-Check Scan..."

        dependencyCheck additionalArguments: '--scan ./', odcInstallation: "OWASP"

        echo "Scan completed. Publishing report..."

        dependencyCheckPublisher pattern: '**/dependency-check-report.xml'

        echo "Dependency-Check Report Published Successfully."
    }
}
