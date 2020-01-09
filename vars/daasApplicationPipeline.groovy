import daas.pipeline.config.PipelineConfig
import hudson.model. *
def call(Closure body) {
    PipelineConfig config

    pipeline {
        //agent any //{ node (label) }
        //agent { docker 'maven:3-alpine' }
        //node {
        agent {
            kubernetes {
                label 'kubernetes-pod'
                defaultContainer 'jnlp'
                yaml """
        apiVersion: v1
        kind: Pod
        metadata:
          labels:
            some-label: some-label-value
        spec:
          securityContext:
            fsGroup: 412
          containers:
          - name: maven
            image: maven:3.3.3
            command:
            - cat
            tty: true
            volumeMounts:
            - mountPath: /usr/bin/docker
              name: docker-bin
            - mountPath: /var/run/docker.sock
              name: docker-sock
          - name: gcloud
            image: gcr.io/cloud-solutions-images/jenkins-k8s-slave
            command:
            - cat
            tty: true
            volumeMounts:
            - mountPath: /usr/bin/docker
              name: docker-bin
            - mountPath: /var/run/docker.sock
              name: docker-sock
          serviceAccount: daas-release-jenkins
          volumes:
          - name: docker-bin
            hostPath:
              path: /usr/bin/docker
            type: File
          - name: docker-sock
            hostPath:
              path: /var/run/docker.sock
            type: Socket
            """
            }
        }
            stages {
                stage("Init pipeline")
                        {
                            steps {
                                script {
                                    config = initPipeline()
                                }
                            }

                        }
                stage("Init config")
                        {
                            steps {
                                script {
                                    initConfig(config)
                                }
                            }

                        }
                stage("Build")
                        {
                        when {
                            expression { return config.ciConfig.codeBuildStage.enable }
                        }

                            steps {
                                container('maven') {
                                    script {
                                        codeBuild(config)
                                    }
                                }
                            }
                        }
                stage("Unit & Integration tests ")
                        {
                    when {
                        expression { return config.ciConfig.codeTestStage.enable }
                    }
                            steps {
                                container('maven') {
                                    script {
                                        codeTest(config)
                                    }
                                }
                            }
                        }
                stage("Quality Scan") {
                    when {
                        expression { return config.ciConfig.codeQualityStage.enable }
                    }
                    steps {
                        container('maven') {
                            script {
                                qualityScan(config)
                            }
                        }
                    }
                }
                stage("Dependencies check")
                        {
                    when {
                        expression{return config.ciConfig.codeSecurityStage.enable}
                    }
                            steps {
                                container('maven') {
                                    script {
                                        dependencyCheck(config)
                                    }
                                }
                            }
                        }
                stage("Archive") {
                    when {
                        expression {
                            return config.ciConfig.codeArchiveStage.enable &&
                                    (config.app.branch.equals("develop") || config.app.branch.startsWith("release-"))
                        }
                    }
                    steps {
                        container('maven') {
                            script {
                                archiveArtifacts(config)
                            }
                        }
                    }
                }
                stage("Build image") {
//                    when {
//                        expression {
//                            return config.cdConfig.containerBuildStage.enable &&
//                                    (config.app.branch.equals("develop") || config.app.branch.startsWith("release-")) &&
//                                    config.app.type.equals("service")
//                        }
//                    }

                    steps {
                        container('gcloud') {
                            script {
                                buildImage(config)
                            }
                        }
                    }
                }
                stage("Deploy to Dev") {
//                    when {
//                        expression{
//                            return config.cdConfig.ocpDevDeployment.enable &&
//                                    (config.app.branch.equals("develop") || config.app.branch.startsWith("release-")) &&
//                                    config.app.type.equals("service")
//                        }
//                    }
                    steps {
                        container('gcloud') {
                            script {
                                deployApp(config, "dev")
                            }
                        }
                    }
                }

            }
        }
//    post('Publish Results') {
//        always {
//            slackBuildResult()
//        }
//    }
}
