// src/ca/bc/gov/iamp/pipeline

package daas.pipeline.config.objects

class Application implements Serializable {
	
	String id = "daas"
	String group = ""
	String name = ""
	String version = "0.0.1"
	String branch = ""
	String latestCommit = ""
	// service or library
	String type = "service"
}