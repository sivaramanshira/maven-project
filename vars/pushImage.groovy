def call(){
    sh 'docker login -u admin -p password 20.102.85.66:8082/docker-local'
    sh 'docker tag myappdev:${SHORT_COMMIT} 20.102.85.66:8082/docker-local/myappdev:${SHORT_COMMIT}'
    sh 'docker push 20.102.85.66:8082/docker-local/myappdev:${SHORT_COMMIT}'
    sh 'docker tag myapprod:${SHORT_COMMIT} 20.102.85.66:8082/docker-local/myapprod:${SHORT_COMMIT}'
    sh 'docker push 20.102.85.66:8082/docker-local/myapprod:${SHORT_COMMIT}'
}
