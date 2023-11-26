pipeline {
    agent any

    stages {
        stage('GetProject') {
            steps {
                // Checkout your GitHub project
                git 'https://github.com/PodgeK92/Padraigspetitions.git'
            }
        }

        stage('Build') {
            steps {
                // Run Maven
                script {
                    // Clean the project
                    sh 'mvn clean:clean'

                    // Resolve dependencies
                    sh 'mvn dependency:copy-dependencies'

                    // Compile the project
                    sh 'mvn compiler:compile'
                }
            }
        }

        stage('Exec') {
            steps {
                sh 'mvn spring-boot:run'
            }
        }
    }
}