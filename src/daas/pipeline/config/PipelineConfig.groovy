

package daas.pipeline.config

import daas.pipeline.config.cd.CdConfig
import daas.pipeline.config.ci.CiConfig
import daas.pipeline.config.objects.Application

class PipelineConfig implements Serializable {

    String baseDir
    Application app = new Application()
    ExternalConfigRepo externalConfig = new ExternalConfigRepo()

    CiConfig ciConfig = new CiConfig()

    CdConfig cdConfig = new CdConfig()
}