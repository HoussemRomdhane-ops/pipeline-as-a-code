#!/usr/bin/groovy

def call() {

	 withSonarQubeEnv('jenkins') {
                    // Optionally use a Maven environment you've configured already
                    withMaven(maven:'maven:3.5') {
                        sh 'mvn clean package sonar:sonar'
                    }
         }

	timeout(time: 3, unit: 'MINUTES') {
               waitForQualityGate abortPipeline: false
        }
}
