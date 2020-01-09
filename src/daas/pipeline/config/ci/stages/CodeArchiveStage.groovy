package daas.pipeline.config.ci.stages

import daas.pipeline.config.objects.Stage

class CodeArchiveStage extends Stage implements Serializable {

    boolean enable = false
    String id = "archive"
    String name = ""
    String engine = "maven"
    String credentials = "daas-nexus"

    CodeArchiveStage() {
        // Stage vars
        this.enable = true
        this.id = "archive"
        this.name = "Archive"

        this.engine = "maven"
        this.goals = "deploy"
        this.params = "-DskipTests=true"
        this.credentials = "daas-nexus"
    }
}
