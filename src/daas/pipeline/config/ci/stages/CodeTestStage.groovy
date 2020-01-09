package daas.pipeline.config.ci.stages

import daas.pipeline.config.objects.Stage

class CodeTestStage extends Stage implements Serializable {

    CodeTestStage() {
        // Stage vars
        this.enable = false
        this.id = "test"
        this.name = "Test"

        this.engine = "maven"
        this.goals = "test"
    }
}
