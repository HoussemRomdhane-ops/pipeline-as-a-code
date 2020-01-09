#!/usr/bin/groovy
import daas.pipeline.config.PipelineConfig

def call(PipelineConfig config) {

	println("dependencyCheck started started")

	println("Check engine")
	if(config.ciConfig.codeSecurityStage.engine == "maven") {
		println("Engine is maven")
		dependencyCheck_Maven(config)
	}
}