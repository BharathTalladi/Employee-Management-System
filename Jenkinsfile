pipeline {
    agent any
    tools{
        maven 'maven_3_9_5'
    }
    stages{
        stage('Build Maven'){
            steps{
                checkout changelog: false, poll: false, scm: scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/BharathTalladi/Employee-Management-System.git']])
                bat 'mvn clean install'
            }
        }
        stage('Build docker image'){
            steps{
                script{
                   bat 'docker build -t talladi412/employeemanagement-0.0.1-SNAPSHOT.jar .'
                }
            }
        }
        stage('Push image to Hub'){
            steps{
                script{
                   withCredentials([string(credentialsId: 'dockerhubpwd', variable: 'dockerhubpwd')]) {
                   bat 'docker login -u talladi412 -p {dockerhubpwd}'

				    }
                    bat 'docker push employeemanagement-0.0.1-SNAPSHOT.jar'
                }
            }
        }
    }
}