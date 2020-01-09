#!/usr/bin/groovy
def info(Map config) {
    slackSend color: "46c9e2", message: appendInfo(config)
}

def warning(Map config) {
    slackSend color: "warning", message: appendInfo(config)
}

def success(Map config) {
    slackSend color: "good", message: appendInfo(config)
}

def failure(Map config) {
    slackSend color: "danger", message: appendInfo(config)
}

def appendInfo(Map config) {
    if(config.appendBuildInfo){
        return config.message +
                "\n Job: ${JOB_NAME}" +
                "\n <${RUN_DISPLAY_URL}|Build #${BUILD_NUMBER}>  |  <${BUILD_URL}changes|Changes>  |  <${BUILD_URL}console|Logs>"
    }
    return config.message
}
