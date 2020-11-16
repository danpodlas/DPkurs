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
    post{
        always{
            allure{[
            includeProperties: false,
                     jdk: '',
                     properties: [[key: 'allure.issues.tracker.pattern', value: 'http://tracker.company.com/%s'],
                     [[key: 'allure.test.management.pattern', value: 'http://tracker.company.com/%s']],
                     reportBuildPolicy: 'ALWAYS',
                     results: [[path: 'target/allure-results'], [path: 'other_target/allure-results']]
            ]
            }
        }
    }
}