pipeline {
  agent any
  triggers {
    pollSCM('*/5 * * * *')
  }
  stages {
    stage('Build') {
      steps {
        echo 'Building the application...'
        sh 'sleep 5' // Simulate build time
      }
    }
    stage('Test') {
      steps {
        echo 'Running tests...'
        sh 'sleep 3' // Simulate test time
      }
    }
    stage('Deploy to Staging') {
      steps {
        echo 'Deploying to staging environment...'
        sh 'sleep 4' // Simulate deployment time
      }
    }
    stage('Deploy to Production') {
      steps {
        input message: 'Deploy to production?'
        echo 'Deploying to production environment...'
        sh 'sleep 5' // Simulate deployment time
      }
    }
  }
}
