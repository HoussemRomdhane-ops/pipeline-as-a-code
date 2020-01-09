package daas.pipeline.config.cd.stages

import daas.pipeline.config.objects.GcpDeployment


class GcpProdDeployment extends GcpDeployment implements Serializable {

    GcpProdDeployment() {
        super()

        this.project = ""
        this.imageTag = '${config.app.version}'

        this.env = "prod"
        this.replicas = 2

        // Test params
        this.testing.enable = false
    }
}
