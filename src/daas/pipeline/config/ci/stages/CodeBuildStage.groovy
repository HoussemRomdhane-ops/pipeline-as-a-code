package daas.pipeline.config.ci.stages

import daas.pipeline.config.objects.Stage

class CodeBuildStage extends Stage implements Serializable {

    CodeBuildStage() {
        // Stage vars
        this.enable = false
        this.id = "build"
        this.name = "Build"

        this.engine = "maven"
        this.goals = "clean package"
        this.params = "-DskipTests=true"
        this.configDir = "external-config/build/maven"
    }
}
