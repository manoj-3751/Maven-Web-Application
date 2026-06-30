def call(String status) {
    if (status == "SUCCESS") {
        slackSend(
            channel: "#jenkinsbuildnotifications",
            color: "good",
            message: "✅ Job: ${env.JOB_NAME}\nBuild: #${env.BUILD_NUMBER}\nStatus: SUCCESS\n${env.BUILD_URL}"
        )
    } else if (status == "FAILURE") {
        slackSend(
            channel: "#jenkinsbuildnotifications",
            color: "danger",
            message: "❌ Job: ${env.JOB_NAME}\nBuild: #${env.BUILD_NUMBER}\nStatus: FAILURE\n${env.BUILD_URL}"
        )
    }
}
