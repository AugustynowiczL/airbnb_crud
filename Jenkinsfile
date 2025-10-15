pipeline {
    agent any

    environment {
        // Define environment variables here
        SONAR_TOKEN = credentials('sonar_token')
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'develop', url: 'https://github.com/AugustynowiczL/airbnb_crud.git'
                // Add your build steps here
            }
        }
        stage('Build & Test') {
            steps {
                bat 'mvn clean install'
                // Add your test steps heree
            }
        }
        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQubeServer') {
                    bat 'mvn sonar:sonar -Dsonar.token=$SONAR_TOKEN'
                }
            }
        }
        stage('Docker Build & Push') {
            steps {
                bat 'docker build -t airbnb-app:latest .'
            }
        }
    }
}