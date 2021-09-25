@Library("shared-library") _
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
          git branch: 'master', url: 'https://github.com/mamtapandey1910/maven-project.git'
        }
      }
      stage ('sonar-scanner'){
        steps {
          sonarScan()
        }
      }
      stage ('Quality Gate'){
        steps {
          qualityGate()
        }
      }
      stage ('build'){
        steps {
            sh 'docker build -t myapprod --target=prod .'
            sh 'docker build -t myappdev --target=dev .'
        }
      }
      stage ('deploy'){
        steps {
           sh 'currentbuild=${BUILD_NUMBER};docker run -it -d -p 9090:8080 -h myhost1 mynodeapprod:$((currentbuild - 1))'
           sh 'currentbuild=${BUILD_NUMBER};docker run -it -d -p 9091:8080 -h myhost2 mynodeappdev:$((currentbuild - 1))'
        }
      }
      stage ('validate'){
        steps {
          sh 'sleep 30'
          sh 'curl http://3.215.178.154:5000/note/'
          sh 'curl http://3.215.178.154:5001/note/'
          sh 'echo "url respondin"'
        }
      }
      
    }
  }
