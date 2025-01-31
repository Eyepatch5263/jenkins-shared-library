def call() {
    timeout(time: 1, unit: "MINUTES") {
        script {
            def qualityGate = waitForQualityGate(abortPipeline: false)
            if (qualityGate.status != 'OK') {
                error "❌ SonarQube Quality Gate failed: ${qualityGate.status}"
            } else {
                echo "✅ SonarQube Quality Gate Passed!"
            }
        }
    }
}
