#!/usr/bin/groovy
import daas.pipeline.config.PipelineConfig
import daas.pipeline.config.objects.GcpDeployment
import daas.pipeline.config.objects.Template

def call(PipelineConfig config, String env) {

    GcpDeployment gcpDeployment
    String dcName

    if("dev".equals(env)){
        gcpDeployment = config.cdConfig.gcpDevDeployment
    } else if("test".equals(env)){
        gcpDeployment = config.cdConfig.gcpTestDeployment
    } else if("prod".equals(env)){
        gcpDeployment =  config.cdConfig.gcp.project
    }

    gcpDeployment.buildVersion = config.app.version.toLowerCase().replace(".", "-")

    println("GCP project name: " + gcpDeployment.project)

//    stage("Check Config") {
//        println("Check Config " + env)
//        //ocpConfigCheck(config, env, ocpDeployment)
//        //ocpResolveParams(config, ocpDeployment)
//        if("recreate".equals(ocpDeployment.type)){
//            ocpConfigRecreate(config, ocpDeployment)
//        } else  if("blue-green".equals(ocpDeployment.type)){
//            ocpConfigBlueGreen(config, ocpDeployment)
//        }
//    }

    stage("Deploy") {
        println("Deploy to " + env)

//                sh "kubectl apply -f $WORKSPACE/external-config/configuration/rbac.yaml"
                sh "kubectl apply -f $WORKSPACE/external-config/deploy/gcp/templates/daas-demo-application-template.yaml"

    }






}
