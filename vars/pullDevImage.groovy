def call(){
    sh 'sshpass -p ShivaJi123123 ssh -t -t -o StrictHostKeyChecking=no Shiva@20.102.85.66 "docker login -u admin -p password 20.102.85.66:8082/docker-local && docker pull 20.102.85.66:8082/docker-local/myappdev:${SHORT_COMMIT}"'
}
