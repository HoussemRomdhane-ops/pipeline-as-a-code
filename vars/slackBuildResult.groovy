#!/usr/bin/groovy
def call() {

    if ( currentBuild.currentResult == "SUCCESS") {
        slackNotification.success message: currentBuild.currentResult, appendBuildInfo: true
    }
    else if( currentBuild.currentResult == "UNSTABLE" || currentBuild.currentResult == "ABORTED" ) {
        slackNotification.warning message: currentBuild.currentResult, appendBuildInfo: true
    }
    else if( currentBuild.currentResult == "FAILURE" || currentBuild.currentResult == "NOT_BUILT" ) {
        slackNotification.failure message: currentBuild.currentResult, appendBuildInfo: true
    }
    else {
        slackNotification.failure message: currentBuild.currentResult, appendBuildInfo: true
    }
}