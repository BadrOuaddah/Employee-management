pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/BadrOuaddah/Employee-management.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Report') {
            steps {
                cucumber()
            }
        }
    }

    post {
        success {
            echo 'Build and Tests succeeded!'
        }
        failure {
            echo 'Build or Tests failed!'
        }
    }
}
