#!/usr/bin/groovy
import daas.pipeline.config.PipelineConfig

def call(PipelineConfig config) {

    println("Init build engine")

    println("Check engine")
    if(config.ciConfig.codeBuildStage.engine == "maven") {
        println("Engine is maven")
        initBuildEngine_Maven(config)
    }
    if(config.ciConfig.codeBuildStage.engine == "gradle") {
        println("Engine is gradle")
        // if it's gradle we should implement a function for gradle build
    }
}