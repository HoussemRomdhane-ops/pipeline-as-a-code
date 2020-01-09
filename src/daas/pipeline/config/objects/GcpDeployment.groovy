package daas.pipeline.config.objects

class GcpDeployment extends Stage implements Serializable{

    String project = ""
    String template = ""
    String env = ""
    String type = "recreate" //rollout, blue-green, canary, a-b, recreate
    String tag = ""
    String oldTag = ""
    String volumes = ""
    String volumeMounts = ""
    Integer replicas = 1
    String imageTag = "latest"
    String buildVersion = ""
    List<Template> templates = new ArrayList<>()
    Map<String, String> secretsMap = new HashMap<>()
    Map<String, String> testSecretsMap = new HashMap<>()
    Stage testing = new Stage(){}
    AutoScaling autoScaling = new AutoScaling()

    GcpDeployment(){
//        Template dcTemplate = new Template()
//        dcTemplate.name = "daas-demo-app-template"
//        dcTemplate.type = "dc"
//        dcTemplate.filePath = "deploy/gcp/templates/daas-demo-app-template.yaml"
//        dcTemplate.params = new HashMap<>()
//        dcTemplate.params.put("APP_NAME", '${config.app.id}')
//        dcTemplate.params.put("APP_ENV", '${ocpDeployment.env}')
//        dcTemplate.params.put("NAMESPACE", '${ocpDeployment.project}')
//        dcTemplate.params.put("OCP_OBJECT_NAME", '${config.app.id}')
//        dcTemplate.params.put("IMAGE_NAME", '${config.app.id}')
//        dcTemplate.params.put("IMAGE_TAG", '${ocpDeployment.imageTag}')
//        dcTemplate.params.put("REPLICAS", '${ocpDeployment.replicas}')
//        dcTemplate.params.put("CFG_SRVR_LBL", '${ocpDeployment.env}')
//        this.templates.add(dcTemplate)
//
//        Template routeTemplate = new Template()
//        routeTemplate.name = "iamp-route-ext-edge-template"
//        routeTemplate.type = "route"
//        routeTemplate.filePath = "deploy/ocp/templates/iamp-route-ext-edge-template.yaml"
//        routeTemplate.params = new HashMap<>()
//        routeTemplate.params.put("APP_NAME", '${config.app.id}')
////        routeTemplate.params.put("APP_ENV", '${ocpDeployment.env}')
//        routeTemplate.params.put("OCP_OBJECT_NAME", '${config.app.id}')
//        routeTemplate.params.put("SERVICE_NAME", '${config.app.id}')
//        routeTemplate.params.put("PORT", "http")
//        this.templates.add(routeTemplate)
//
//        Template mgmtRouteTemplate = new Template()
//        mgmtRouteTemplate.name = "iamp-route-ext-edge-template"
//        mgmtRouteTemplate.type = "route"
//        mgmtRouteTemplate.filePath = "deploy/ocp/templates/iamp-route-ext-edge-template.yaml"
//        mgmtRouteTemplate.params = new HashMap<>()
//        mgmtRouteTemplate.params.put("APP_NAME", '${config.app.id}')
////        routeTemplate.params.put("APP_ENV", '${ocpDeployment.env}')
//        mgmtRouteTemplate.params.put("OCP_OBJECT_NAME", '${config.app.id}-mgmt')
//        mgmtRouteTemplate.params.put("SERVICE_NAME", '${config.app.id}')
//        mgmtRouteTemplate.params.put("PORT", "mgmt")
//        mgmtRouteTemplate.params.put("PATH", "/actuator")
//        this.templates.add(mgmtRouteTemplate)
    }
}
