pipeline {
    agent any
   //
    stages {
/*         stage('Testes Unitarios') {
            steps {
                // Download do projeto de teste unitario
                sh 'echo Inicio dos testes unitarios Baixando projeto qaacademy_selenium_cucumber.git'
                git 'https://github.com/emersonqaacademy/qaacademy_selenium_cucumber.git'

                // Executar os testes unitarios usando Maven
                sh "mvn clean install test"

            }
            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    junit '**//* target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target *//*.jar'
                }

            }
        } */
        stage('Build Bugbank') {
                    steps {
                        // Download do projeto de teste unitario
                        sh 'echo Baixando Bugbank'
                        git 'https://github.com/qaacademy/bugbank.git'
                        sh 'echo Bugbank está em execução'

                    }
        }
        stage('Test E2E') {
                            steps {
                                // Download do projeto de teste unitario
                                sh 'echo Baixando testes e2e'
                                git 'https://github.com/emersonqaacademy/qaacademy_selenium_cucumber.git'
                                sh 'mvn clean install -Dtest=Runner test'

                            }
        }

    }
}