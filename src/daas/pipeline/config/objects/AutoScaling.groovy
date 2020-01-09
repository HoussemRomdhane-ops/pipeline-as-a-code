package daas.pipeline.config.objects

class AutoScaling extends Stage implements Serializable {

    int minReplicas = 2
    int maxReplicas = 4
    int cpuThresholdPercentage = 70
    int memoryThresholdPercentage = 70

    AutoScaling(){
        this.id = "autoscaling"
        this.name = "Autoscaling"
    }
}
