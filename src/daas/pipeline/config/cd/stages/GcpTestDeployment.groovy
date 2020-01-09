package daas.pipeline.config.cd.stages

import daas.pipeline.config.objects.GcpDeployment

class GcpTestDeployment extends GcpDeployment implements Serializable {

    GcpTestDeployment() {
        super()

        this.project = ""
        this.imageTag = '${config.app.version}'

        this.env = "test"
        this.replicas = 2

        // Test params
        this.testing.enable = true
        this.testing.id = "load-testing"
        this.testing.name = "Load Testing"
        this.testing.engine = "maven"
        this.testing.goals = "loadtest"
    }
}
