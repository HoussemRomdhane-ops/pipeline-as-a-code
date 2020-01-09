#!/usr/bin/groovy
import daas.pipeline.config.PipelineConfig

def call(PipelineConfig config) {

	println("Archive artifacts started")

	println("Check engine")
	if(config.ciConfig.codeArchiveStage.engine == "maven") {
		println("Engine is maven")
		archiveArtifacts_Maven(config)
	}
}