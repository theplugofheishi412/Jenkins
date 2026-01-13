pipeline {
  agent any
  options {
    timestamps()
    ansiColor('xterm')
  }
  stages {
    stage('Checkout') {
      steps {
        checkout scm
      }
    }
    stage('Build') {
      steps {
        sh 'mvn -B -DskipTests=false clean package'
      }
    }
    stage('Test') {
      steps {
        sh 'mvn -B test'
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
      junit 'target/surefire-reports/*.xml'
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
