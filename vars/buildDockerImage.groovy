#!/usr/bin/groovy
import daas.pipeline.config.PipelineConfig


def call(PipelineConfig config) {
    println( "Build Image on " + config.cdConfig.containerBuildStage.cloudProvider + " started")

    String appJar = config.app.id + "/target/" + config.app.id + "-" + config.app.version + "-SNAPSHOT.jar"
    println(appJar)

def  imageTag = "gcr.io/${config.cdConfig.gcpDevDeployment.project}/${config.app.id}:${env.BRANCH_NAME}.${env.BUILD_NUMBER}"

    sh 'set +x && TOKEN=`gcloud auth print-access-token` && docker login -u oauth2accesstoken -p "$TOKEN" https://gcr.io'
//    sh "rm -rf gcp-build && mkdir -p gcp-build/deployments"
//    sh "cp ${appJar} gcp-build/deployments/"
    dir(config.app.id) {
        sh "pwd"
        sh "PYTHONUNBUFFERED=1 docker build -t ${imageTag} . || true"
        //  sh "docker run hello-world"
    sh " docker push ${imageTag}"
        //  sh "docker info || true"
    }
}
