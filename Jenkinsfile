pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                git  'https://github.com/danpodlas/DPkurs.git'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn clean test'
            }
        }
    }
}