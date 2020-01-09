#!/usr/bin/groovy
import jenkins.model.*

def call(credentialsId) {

    def creds = com.cloudbees.plugins.credentials.CredentialsProvider.lookupCredentials(com.cloudbees.plugins.credentials.Credentials.class, Jenkins.instance, null, null);

    def credential = creds.find {it.id == credentialsId}
    if (!credential) {
        echo "Unable to pickup credential from Jenkins"
        return null
    }

    return credential;
}
