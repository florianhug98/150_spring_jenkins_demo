@Library("150-shared-library") _
import ch.bs.hug.Constants

def CONTAINER_NAME = "spring-jenkins-demo-arm"

pipeline {
  agent {
    docker { image 'maven:3.8.4-openjdk-17' }
  }

  stages {
    stage('init') {
      steps {
        echo 'Currently in branch: ' + env.BRANCH_NAME
        sh 'java --version'
        sh 'mvn -v'
      }
    }

    stage ('compile') {
      steps {
        sh 'mvn clean compile'
      }
    }

    stage ('test') {
        steps {
            sh "mvn verify"
        }
    }

    stage ("nexus deploy") {
        when {
            branch "master"
        }
        steps {
          deployToNexus(
            nexusVersion: Constants.NEXUS_VERSION,
            nexusProtocol: Constants.NEXUS_PROTOCOL,
            nexusUrl: Constants.NEXUS_URL,
            nexusRepository: Constants.NEXUS_REPOSITORY,
            nexusCredentialsId: Constants.NEXUS_CREDENTIALS_ID
          )
        }
    }
    
    stage ("dockerize") {
      when {
        branch "master"
      }
      steps {
        sh "mvn jib:build"
      }
    }
    
    stage ("server deploy"){
      when {
        branch "master"
      }
      steps {
        pom = readMavenPom file: "pom.xml"
        echo ${CONTAINER_NAME} + ':' + ${pom.version}
        deployToStage()
      }
    }
  }
}
