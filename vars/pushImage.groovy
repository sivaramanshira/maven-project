def call(){
    sh 'docker login -u admin -p password 20.102.85.66:8082/docker-local'
    sh 'docker tag myappdev 20.102.85.66:8082/docker-local/myappdev'
    sh 'docker push 20.102.85.66:8082/docker-local/myappdev'
}
