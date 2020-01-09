
package daas.pipeline.config.cd

import daas.pipeline.config.cd.stages.ContainerBuildStage
import daas.pipeline.config.cd.stages.GcpDevDeployment
import daas.pipeline.config.cd.stages.GcpProdDeployment
import daas.pipeline.config.cd.stages.GcpTestDeployment


class CdConfig implements Serializable {

    ContainerBuildStage containerBuildStage = new ContainerBuildStage()
    GcpDevDeployment gcpDevDeployment = new GcpDevDeployment()
    GcpTestDeployment gcpTestDeployment = new GcpTestDeployment()
    GcpProdDeployment gcpProdDeployment = new GcpProdDeployment()
}