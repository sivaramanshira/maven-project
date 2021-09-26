def call(){
    sh 'docker login -u admin -p password 40.71.77.234:8082/app-images'
    sh 'docker tag myapprod 40.71.77.234:8082/app-images/myapprod'
    sh 'docker push 40.71.77.234:8082/app-images/myapprod'
}
