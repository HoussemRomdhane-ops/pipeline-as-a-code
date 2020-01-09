#!/usr/bin/groovy

def call() {
	//withMaven(maven:'maven:3.5') {
		sh "mvn clean package -DskipTests=true"
	//}
}
