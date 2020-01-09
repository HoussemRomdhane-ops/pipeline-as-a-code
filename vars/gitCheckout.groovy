#!/usr/bin/groovy

def call(Map config) {
    checkout([$class: 'GitSCM',
              branches: [[name: "*/"+config.branch]],
              doGenerateSubmoduleConfigurations: false,
              extensions: [[$class: 'RelativeTargetDirectory', relativeTargetDir: config.directory]],
              submoduleCfg: [],
              userRemoteConfigs: [[credentialsId: config.credentialsId, url: config.repoURL]]
    ])
}