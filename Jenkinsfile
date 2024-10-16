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
                sh 'mvn clean install -DskipTests'
            }
        }

        stage('Test') {
            steps {
                echo 'Running tests...'
                sh 'mvn test'
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
