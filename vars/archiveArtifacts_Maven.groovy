#!/usr/bin/groovy
import daas .pipeline.config.PipelineConfig

def call(PipelineConfig config) {

	println("Code build maven started")

	def credentials = getCredentials(config.ciConfig.codeArchiveStage.credentials)

	dir(config.app.id) {
		sh "mvn ${config.ciConfig.codeArchiveStage.goals} ${config.ciConfig.codeArchiveStage.params} " +
				"-Dinternal.repo.username=${credentials.username} " +
				"-Dinternal.repo.password=${credentials.password.value}"
	}
}