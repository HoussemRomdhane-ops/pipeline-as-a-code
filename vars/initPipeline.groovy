#!/usr/bin/groovy
import daas.pipeline.config.PipelineConfig
import groovy.json.JsonSlurper
import groovy.json.JsonBuilder

def call(PipelineConfig) {

    println("Init pipeline")
   slackNotification.info message: 'STARTED', appendBuildInfo: true
    PipelineConfig pipelineConfig

    // Get Json
    if (fileExists('pipeline-config.json')) {
        String config = readFile file: 'pipeline-config.json'
        println("Params: \n" + config)
        // using Map to convert to Person object type
        pipelineConfig = new PipelineConfig(new JsonSlurper().parseText(config))
    } else if (fileExists('pipeline-config.yaml')) {
        // Do yaml init
    } else {
        println("No init params")
        pipelineConfig = new PipelineConfig()
    }


    // Workspace base directory
    pipelineConfig.baseDir = WORKSPACE

    println("Get app info")
    // App info
    //pipelineConfig.app =
   // getAppInfo(pipelineConfig)

    // Branch
    pipelineConfig.app.branch = BRANCH_NAME

    // Fix App dir
    initPipeline_FixAppDirectory(pipelineConfig)

    println("Pipeline Configs: \n" + new JsonBuilder(pipelineConfig).toPrettyString())

    println("return config")
    return pipelineConfig
}
