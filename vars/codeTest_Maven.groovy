#!/usr/bin/groovy
import daas.pipeline.config.PipelineConfig

def call(PipelineConfig config) {

	println("Code test maven started")

	dir(config.app.id) {
		sh "mvn ${config.ciConfig.codeTestStage.goals} ${config.ciConfig.codeTestStage.params}"
	}
}