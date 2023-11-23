#!groovy

import jenkins.model.*
import hudson.security.*

def instance = Jenkins.getInstance()

println "--> creating local user 'Jeff'"

def hudsonRealm = new HudsonPrivateSecurityRealm(false)

def username = System.getenv("JENKINS_USERNAME")
def password = System.getenv("JENKINS_PASSWORD")
hudsonRealm.createAccount(username, password)
instance.setSecurityRealm(hudsonRealm)

def strategy = new FullControlOnceLoggedInAuthorizationStrategy()
instance.setAuthorizationStrategy(strategy)
instance.save()