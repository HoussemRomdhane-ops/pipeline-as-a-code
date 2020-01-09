#!/usr/bin/groovy
import daas.pipeline.config.PipelineConfig

def call(PipelineConfig config) {

	println(config.ciConfig.codeQualityStage.name + " " + config.ciConfig.codeQualityStage.engine + " started")

//	String sonarProjectKey = (config.app.group + ":" + config.app.id + ":" +
//			config.app.branch).replace("/", ":")
//	String sonarProjectName = config.app.name + " (Branch: " + config.app.branch + ")"

	withSonarQubeEnv(config.ciConfig.codeQualityStage.sonarConfigName) {
		dir(config.app.id) {
			sh "mvn ${config.ciConfig.codeQualityStage.goals} ${config.ciConfig.codeQualityStage.params} " +
					"-Dsonar.branch=\"${config.app.branch}\" "
//					"-Dsonar.projectKey=\"${sonarProjectKey}\" " +
//					"-Dsonar.projectName=\"${sonarProjectName}\""
		}
  	}
	timeout(time: config.ciConfig.codeQualityStage.sonarGatewayTimeout, unit: config.ciConfig.codeQualityStage.sonarGatewayTimeoutUnit) {
		def qg = waitForQualityGate(config.ciConfig.codeQualityStage.sonarGatewayConfigName)
		if (qg.status != 'OK') {
			error "Pipeline aborted due to quality gate failure: ${qg.status}"
		}
	}
}
