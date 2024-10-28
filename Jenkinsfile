pipeline {
    agent any

    tools {
        maven 'Maven 3.9.9'
    }

    environment {
        KARATE_ENV = 'docker'
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
                sh 'mvn clean install -DskipTests -DKARATE_ENV=docker'
            }
        }

        stage('Test') {
            steps {
                echo 'Running unit tests...'
                sh 'mvn test -DKARATE_ENV=docker'
            }
        }

        stage('Start Keycloak') {
            steps {
                echo 'Starting Keycloak container...'
                sh 'docker run -d --name keycloak -p 8080:8080 -e KEYCLOAK_USER=admin -e KEYCLOAK_PASSWORD=admin jboss/keycloak'
                sleep time: 20, unit: 'SECONDS' // Wait for Keycloak to fully start
            }
        }

        stage('Integration Tests and Package') {
            steps {
                echo 'Running integration tests and packaging the application...'
                sh 'mvn verify -DKARATE_ENV=docker'
            }
        }

        stage('JaCoCo Report') {
            steps {
                echo 'Generating JaCoCo code coverage report...'
                jacoco execPattern: '**/target/jacoco.exec',
                       classPattern: '**/target/classes',
                       sourcePattern: '**/src/main/java',
                       exclusionPattern: '**/src/test/java'
            }
        }
    }

    post {
        always {
            echo 'Stopping and removing Keycloak container...'
            sh 'docker rm -f keycloak'
        }
        success {
            echo 'Build, Tests, and Package succeeded!'
            junit '**/target/surefire-reports/*.xml'
            archiveArtifacts artifacts: '**/target/site/jacoco/*', allowEmptyArchive: true
        }
        failure {
            echo 'Build or Tests failed!'
        }
    }
}