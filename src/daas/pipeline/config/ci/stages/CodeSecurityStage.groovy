package daas.pipeline.config.ci.stages

import daas.pipeline.config.objects.Stage

class CodeSecurityStage extends Stage implements Serializable {

    CodeSecurityStage() {
        // Stage vars
        this.enable = false
        this.id = "security"
        this.name = "Dependencies Scanning"
        this.engine = "maven"
        this.goals = "dependency-check:check"
        this.params = "-DskipTests=true"
    }
}
