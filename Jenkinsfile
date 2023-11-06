pipeline {
    agent any
    tools{
        maven 'maven_3_9_5'
    }
    stages{
        stage('Build Maven'){
            steps{
                checkout changelog: false, poll: false, scm: scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/BharathTalladi/Employee-Management-System']])
                bat 'mvn clean install'
            }
        }
    }
}
