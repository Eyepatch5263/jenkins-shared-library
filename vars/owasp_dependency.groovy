def call() {
    echo "Starting Dependency-Check Scan..."
    
    try {
        dependencyCheck additionalArguments: '--scan ./', odcInstallation: "OWASP"
        echo "Dependency-Check Completed Successfully."
    } catch (Exception e) {
        echo "Error running Dependency-Check: ${e.message}"
        error("Dependency-Check failed")
    }

    try {
        dependencyCheckPublisher pattern: '**/dependency-check-report.xml'
        echo "Report Published Successfully."
    } catch (Exception e) {
        echo "Error publishing report: ${e.message}"
        error("Publishing Report failed")
    }
}
