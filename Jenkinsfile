pipeline {
    agent any
    environment {
        PATH = "/opt/homebrew/Cellar/maven/3.8.6/bin:$PATH"
    }
    stages {
         stage('Testes Unitarios') {
            steps {
                // Download do projeto de teste unitario
                sh 'echo Inicio dos testes unitarios Baixando projeto qaacademy_selenium_cucumber.git'
                git 'https://github.com/emersonqaacademy/qaacademy_selenium_cucumber.git'

                // Executar os testes unitarios usando Maven
                sh "mvn clean install test"

            }

        }
        stage('Build Bugbank') {
                    steps {
                        // Download do projeto de teste unitario
                        sh 'echo Baixando Bugbank'
                        git 'https://github.com/qaacademy/bugbank.git'
                        sh 'yarn dev'

                    }
        }
        stage('Test E2E') {
                            steps {
                                // Download do projeto de teste unitario
                                sh 'echo Baixando testes e2e'
                                git 'https://github.com/emersonqaacademy/qaacademy_selenium_cucumber.git'
                                sh 'mvn -Dtest=Runner test'

                            }

        }

    }
}