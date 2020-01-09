package daas.pipeline.config.cd.stages

import daas.pipeline.config.objects.GcpDeployment


class GcpDevDeployment extends GcpDeployment implements Serializable {

    GcpDevDeployment() {
        super()

        this.project = "daas-demo"
        this.env = ""
        this.template = "deploy/gcp/templates/daas-demo-app-template.yaml"

        // Test params
        this.testing.enable = true
        this.testing.id = "system-testing"
        this.testing.name = "System Testing"
        this.testing.engine = "maven"
        this.testing.goals = "test"

        // Auto scaling
        this.autoScaling.enable = false
    }
}
