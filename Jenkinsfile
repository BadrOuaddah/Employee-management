pipeline {
    agent any

    tools {
            maven 'Maven 3.9.9'
        }

        environment {
            DB_URL = 'jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE'
            DB_USERNAME = 'sa'
            DB_PASSWORD = ''
            KEYCLOAK_REALM = 'SpringBootKeycloak'
            KEYCLOAK_PORT = '9091'
        }

    stages {

        stage('Prepare Environment') {
            steps {
                script {
                    echo 'Setting up Keycloak Docker container...'
                    sh '''
                    docker run -d --name keycloak -p ${KEYCLOAK_PORT}:8080 \
                    -e KEYCLOAK_USER=admin -e KEYCLOAK_PASSWORD=admin \
                    quay.io/keycloak/keycloak:latest start-dev
                    '''

                    echo 'Waiting for Keycloak to start...'
                    sh 'sleep 20'
                }
            }
        }

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
                sh 'mvn clean install -DskipTests'
            }
        }

        stage('Tests') {
            steps {
                echo 'Running tests...'
                sh '''
                mvn test -Dspring.datasource.url=${DB_URL} \
                -Dspring.datasource.username=${DB_USERNAME} \
                -Dspring.datasource.password=${DB_PASSWORD} \
                -Dspring.security.oauth2.client.provider.keycloak.issuer-uri=http://localhost:${KEYCLOAK_PORT}/realms/${KEYCLOAK_REALM}
                '''
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
        cleanup {
            script {
                echo 'Cleaning up Keycloak container...'
                sh 'docker stop keycloak'
                sh 'docker rm keycloak'
            }
        }
    }
}
