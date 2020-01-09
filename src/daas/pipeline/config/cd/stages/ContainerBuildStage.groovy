package daas.pipeline.config.cd.stages

import daas.pipeline.config.objects.Stage

class ContainerBuildStage extends Stage implements Serializable {

    boolean localArtifact = true
    String cloudProvider = "GCP"
//    String baseImage = "registry.access.redhat.com/jboss-fuse-6/fis-java-openshift:2.0"
//    String baseImage = "registry.access.redhat.com/redhat-openjdk-18/openjdk18-openshift:1.6"

    ContainerBuildStage() {

        // Stage vars
        this.enable = true
        this.id = "containerBuild"
        this.name = "Container Build"
        this.engine = "docker"
    }
}
