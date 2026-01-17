pipeline {
  agent any
  
  tools {
    maven 'Maven'
  }
  
  environment {
    // L'ID de ton serveur Artifactory dans Jenkins
    ARTIFACTORY_SERVER = 'Artifactory' 
    REPOSITORY = 'java-calculatrice'
  }
  
  options {
    timestamps()
  }
  
  stages {
    stage('Checkout') {
      steps {
        checkout scm
      }
    }
    
    stage('Build & Test') {
      steps {
        sh 'mvn -B clean test package'
      }
    }
    
    stage('Archive') {
      steps {
        archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
      }
    }
    
    stage('Publish to Artifactory') {
      steps {
        script {
          echo 'Publication vers Artifactory...'
          
          // Récupère le serveur Artifactory
          def server = Artifactory.server(ARTIFACTORY_SERVER)
          
          // Définit ce qu'on veut uploader
          def uploadSpec = """{
            "files": [{
              "pattern": "target/*.jar",
              "target": "${REPOSITORY}/"
            }]
          }"""
          
          // Upload
          def buildInfo = server.upload(uploadSpec)
          
          // Publie les infos du build
          server.publishBuildInfo(buildInfo)
          
          echo " Artefact publier dans ${REPOSITORY}"
        }
      }
    }
  }
  
  post {
    always {
      junit testResults: 'target/surefire-reports/*.xml',
            allowEmptyResults: true
      cleanWs()
    }
    success {
      echo 'Pipeline: SUCCESS'
    }
    failure {
      echo 'Pipeline: FAILURE'
    }
  }
}