#!/usr/bin/groovy
import daas.pipeline.config.PipelineConfig

def call(PipelineConfig config) {

	println("Build Image started ")

	println("Check cloud Provider ")
	if(config.cdConfig.containerBuildStage.cloudProvider == "GCP") {
		println("Build on" + " " + "${config.cdConfig.containerBuildStage.cloudProvider}")
		buildDockerImage(config)
	}
	if(config.cdConfig.containerBuildStage.cloudProvider == "OCP") {
		println("Build on Openshift container")
	}
}