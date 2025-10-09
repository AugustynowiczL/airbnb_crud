pipeline {
    agent any

    environment {
        // Define environment variables here
        SONAR_TOKEN = credentials('sonar_token')
        DOCKER_IMAGE = 'airbnb-app:latest'
    }}

    stages {
        stage('Checkout') {
            steps {
                git branch: 'develop', url: 'https://github.com/AugustynowiczL/airbnb_crud.git'
                // Add your build steps here
            }
        }
        stage('Build & Test') {
            steps {
                sh 'mvn clean install'
                // Add your test steps here
            }
        }
        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQubeServer') {
                    sh 'mvn sonar:sonar -Dsonar.login=$SONAR_TOKEN'
                }
            }
        }
        stage('Docker Build & Push') {
            steps {
                sh 'docker build -t airbnb-app:latest .'
            }
        }
    }
}