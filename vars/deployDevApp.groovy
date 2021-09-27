def call(){
    sh 'sshpass -p ShivaJi123123 ssh -t -t -o StrictHostKeyChecking=no Shiva@20.102.85.66 "docker run -d -p 9091:8080 20.102.85.66:8082/docker-local/myappdev:${SHORT_COMMIT}"'
}
