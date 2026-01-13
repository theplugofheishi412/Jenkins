pipeline {
  agent any

  tools {
    maven 'Maven'
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
