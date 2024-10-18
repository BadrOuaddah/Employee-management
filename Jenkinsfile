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

        stage('Clean') {
            steps {
                echo 'Cleaning the project...'
                sh 'mvn clean install -U'
            }
        }

        stage('Build') {
            steps {
                echo 'Building the project...'
                sh 'mvn clean compile'
            }
        }

        stage('Tests') {
            steps {
                echo 'Running tests...'
                sh 'mvn test'
            }
        }

        stage('Integration Tests and Package') {
            steps {
                echo 'Running integration tests and packaging the application...'
                sh 'mvn verify'
            }
        }
    }

    post {
        always {
            echo 'Archiving test results and logs...'
            archiveArtifacts artifacts: '**/target/*.jar', allowEmptyArchive: true
            junit 'target/surefire-reports/*.xml'
        }
        success {
            echo 'Build, Tests, and Package succeeded!'
        }
        failure {
            echo 'Build or Tests failed! Check logs for details.'
            archiveArtifacts artifacts: 'target/logs/*.log', allowEmptyArchive: true
        }
    }
}
