#!/usr/bin/groovy
import daas.pipeline.config.PipelineConfig

def call(PipelineConfig config) {

    println("Init Config")
    // Get external config repo
    gitCheckout repoURL: config.externalConfig.repoUrl, branch: config.externalConfig.branch, directory: config.externalConfig.localDir, credentialsId: config.externalConfig.credentials

    // Init build engines
    initBuildEngine(config)

}