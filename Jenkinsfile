@Library("150-shared-library") _
pipeline {
  agent {
    docker { image 'maven:3.8.4-openjdk-17' }
  }

  stages {
    stage('init') {
      steps {
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
          deployToNexus()
        }
    }
  }
}
