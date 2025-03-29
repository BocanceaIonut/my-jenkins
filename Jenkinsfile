pipeline {
  agent any
  triggers {
    pollSCM('*/5 * * * *')
  }
  stages {
    stage('Build') {
      steps {
        echo 'Building..'
        sh '''
          cd my-app
          pip install -r requirements.txt
        '''
      }
    }
    stage('Test') {
      steps {
        echo 'Testing..'
        sh '''
          cd my-app
          python3 hello.py
          python3 hello.py --name=bdev
        '''
      }
    }
    stage('Deploy to Staging') {
      steps {
        echo 'Deploying to Staging..'
        sh '''
          echo "Deploying to staging environment..."
        '''
      }
    }
    stage('Deploy to Production') {
      steps {
        echo 'Deploying to Production..'
        sh '''
          echo "Deploying to production environment..."
        '''
      }
    }
  }
}
