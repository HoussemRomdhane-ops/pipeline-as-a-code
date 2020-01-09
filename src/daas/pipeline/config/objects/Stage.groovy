package daas.pipeline.config.objects

abstract class Stage implements Serializable{

    boolean enable = true
    String id
    String name

    String engine = ""
    String goals = ""
    String params = ""
    String configDir = ""
    String credentials = ""
}
