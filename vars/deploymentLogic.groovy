#!/usr/bin/groovy

def call(namespace) {
 
 def project = 'daas-demo'
 def  appName = 'sample-app'
 def  imageTag = "gcr.io/${project}/${appName}:${env.BRANCH_NAME}.${env.BUILD_NUMBER}"

 switch (namespace){
  case "canary":

    sh("sed -i.bak 's#gcr.io/green-dispatch-219519/sample-app:v1#${imageTag}#' ./k8s/canary/*.yaml")
         
    sh("kubectl --namespace=canary apply -f k8s/canary/")
   
    break
          
  case "production":

    sh("sed -i.bak 's#gcr.io/green-dispatch-219519/sample-app:v1#${imageTag}#' ./k8s/production/*.yaml")
         
    sh("kubectl --namespace=production apply -f k8s/production/")

    break
   
  default:  
   // Create namespace if it doesn't exist
    sh("kubectl get ns ${env.BRANCH_NAME} || kubectl create ns ${env.BRANCH_NAME}")
   //Don't use public load balancing for development branches
    sh("sed -i.bak 's#gcr.io/green-dispatch-219519/sample-app:v1#${imageTag}#' ./k8s/dev/*.yaml")  
    sh("kubectl --namespace=${env.BRANCH_NAME} apply -f k8s/dev/")
          
    break       
}    

}
