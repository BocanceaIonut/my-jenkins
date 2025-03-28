pipeline {
  agent { 
    node {
      label 'docker-agent-py'
    }
  }
  triggers {
    pollSCM('*/5 * * * *')
  }
  stages {
    stage('Build') {
      steps {
        echo "Building.."
        sh '''
          cd my-app
          pip install -r requirements.txt
          '''
      }
    }
    stage('Test') {
      steps {
        echo "Testing.."
        sh '''
          cd my-app
          python3 hello.py
          python3 hello.py --name=bdev
          '''
      }
    }
    stage('Deliver') {
      steps {
        echo 'Deliver....'
        sh '''
          echo "doing delivery stuff.."
          '''
      }
    }
  }
}
