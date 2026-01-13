pipeline {
  agent any

  options {
    timestamps()
  }

  stages {
    stage('Checkout') {
      steps {
        checkout scm
      }
    }

    stage('Build') {
      steps {
        ansiColor('xterm') {
          sh 'mvn -B -DskipTests=false clean package'
        }
      }
    }

    stage('Test') {
      steps {
        ansiColor('xterm') {
          sh 'mvn -B test'
        }
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
