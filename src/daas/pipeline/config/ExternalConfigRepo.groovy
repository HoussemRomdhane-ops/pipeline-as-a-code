

package daas.pipeline.config

class ExternalConfigRepo implements Serializable {

	String repoUrl = "https://github.com/opticca-consulting/daas-pipeline-config.git" //application configuration github URL
	String branch = "master"
	String credentials = "git" //we should impliment the jenkins account for github
	String localDir = "external-config"

	String latestCommit = ""
}
