@Library("shared-lib") _
pipeline {
  environment {
    PATH = "$PATH:/usr/local/bin/"
  }
  agent any 
  tools {
    maven 'maven'
  }
    stages {
      stage ('checkout'){
        steps {
          git branch: 'dev', url: 'https://github.com/sivaramanshira/maven-project.git'
        }
      }
      stage ('sonar-scanner'){
        steps {
          sonarScan()
        }
      }
      stage ('build'){
        steps {
            prodBuild()
            devBuild()
        }
      }
      stage ('push to artifactory'){
        steps {
           pushImage()
        }
      }
        stage ('pull dev from artifactory'){
        steps {
           pullDevImage()
        }
      }
      stage ('Deployment Dev'){
        steps {
           deployDevApp()
        }
      }
      
    }
  }
