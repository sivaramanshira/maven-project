
pipeline {
  environment {
    PATH = "$PATH:/usr/local/bin/"
  }
  agent any 
    stages {
      stage ('checkout'){
        steps {
          git branch: 'master', url: 'https://github.com/mamtapandey1910/maven-project.git'
        }
      }
      stage ('build'){
        steps {
          sh 'docker build -t myapprod:${BUILD_NUMBER} --target=prod .'
            sh 'docker build -t myappdev:${BUILD_NUMBER} --target=dev .'
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
