#!/usr/bin/groovy
import daas.pipeline.config.PipelineConfig

def call(PipelineConfig config, String env) {

	println("Deploy App started ")

	//println("Check cloud Provider ")
	//if(config.cdConfig.containerBuildStage.cloudProvider == "ocp" ) {
		println("Deploy to GCP " + env)
		deployToGCP(config, env)
	//}
}