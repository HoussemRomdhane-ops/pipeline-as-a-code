// src/ca/bc/gov/iamp/pipeline

package daas.pipeline.config.ci

import daas.pipeline.config.ci.stages.CodeArchiveStage
import daas.pipeline.config.ci.stages.CodeBuildStage
import daas.pipeline.config.ci.stages.CodeQualityStage
import daas.pipeline.config.ci.stages.CodeSecurityStage
import daas.pipeline.config.ci.stages.CodeTestStage



class CiConfig implements Serializable {

    CodeBuildStage codeBuildStage = new CodeBuildStage()
    CodeTestStage codeTestStage = new CodeTestStage()
    CodeQualityStage codeQualityStage = new CodeQualityStage()
    CodeSecurityStage codeSecurityStage = new CodeSecurityStage()
    CodeArchiveStage codeArchiveStage = new CodeArchiveStage()
}