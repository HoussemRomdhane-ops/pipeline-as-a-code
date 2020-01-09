package daas.pipeline.config.ci.stages

import daas.pipeline.config.objects.Stage

class CodeQualityStage extends Stage implements Serializable {

    String sonarConfigName = "sonar"
    String sonarGatewayConfigName = "sonar"
    String sonarGatewayTimeoutUnit = "MINUTES"
    Integer sonarGatewayTimeout = 5

    CodeQualityStage() {
        // Stage vars
        this.enable = true
        this.id = "quality"
        this.name = "Quality Scanning"
        this.engine = "sonar"
        this.goals = "sonar:sonar"
        this.params = "-DskipTests=true"
    }
}
