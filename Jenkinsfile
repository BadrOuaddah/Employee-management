pipeline {
    agent any

    tools {
            maven 'Maven 3.9.9'
        }

    stages {
        stage('Checkout') {
            steps {
                echo 'Cloning the repository...'
                git branch: 'master', url: 'https://github.com/BadrOuaddah/Employee-management.git'
            }
        }

        stage('Build') {
            steps {
                echo 'Building the project...'
                bat 'mvn clean install -DskipTests'
            }
        }

        stage('Test') {
            steps {
                echo 'Running tests...'
                bat 'mvn test'
            }
        }

        stage('Integration Tests and Package') {
            steps {
                echo 'Running integration tests and packaging the application...'
                bat 'mvn verify'
            }
        }
    }

    post {
        success {
            echo 'Build, Tests, and Package succeeded!'
        }
        failure {
            echo 'Build or Tests failed!'
        }
    }
}