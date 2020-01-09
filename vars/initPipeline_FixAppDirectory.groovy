#!/usr/bin/groovy
import daas.pipeline.config.PipelineConfig

def call(PipelineConfig config) {

    println("Fix App Directory")

    // Make app directory at parent
    sh "mkdir ../${config.app.id}"

    // Move all files to app directory
    sh "mv * ../${config.app.id}"
    //shopt -s dotglob nullglob;
    // Bring app directory back to .
    sh "mv ../${config.app.id} ."
}