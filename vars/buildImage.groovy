#!/usr/bin/env groovy

def call()  {
    echo " building the image ..."
    withCredentials([usernamePassword(credentialsId:'docker-hub',usernameVariable: 'USERNAME', passwordVariable:'PASSWORD' )]){
        sh 'docker build -t walidelbir/devops-bootcamp:jma-2.0 .'
        sh "echo $PASSWORD | docker login -u $USERNAME --password-stdin"
        sh 'docker push walidelbir/devops-bootcamp:jma-2.0'
    }
}