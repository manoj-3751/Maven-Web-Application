def call(String buildStatus = 'STARTED') {

    // If buildStatus is null, set it to SUCCESS
    buildStatus = buildStatus ?: 'SUCCESS'

    // Default values
    def colorCode = '#FF0000'
    def subject = "${buildStatus}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'"
    def summary = "${subject}\n${env.BUILD_URL}"

    // Override color based on build status
    if (buildStatus == 'STARTED') {
        colorCode = '#FFFF00'   // Yellow
    } else if (buildStatus == 'SUCCESS') {
        colorCode = '#00FF00'   // Green
    } else {
        colorCode = '#FF0000'   // Red
    }

    // Send Slack notification
    slackSend(
        color: colorCode,
        message: summary
    )
}
