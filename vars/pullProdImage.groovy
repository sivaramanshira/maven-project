def call(){
    sh 'sshpass -p ShivaJi123123 ssh -t -t -o StrictHostKeyChecking=no Shiva@10.1.2.4 "docker login -u admin -p password 20.102.85.66:8082/docker-local && docker pull 20.102.85.66:8082/docker-local/myapprod:${SHORT_COMMIT}"'
    sh 'sshpass -p ShivaJi123123 ssh -t -t -o StrictHostKeyChecking=no Shiva@10.1.2.5 "docker login -u admin -p password 20.102.85.66:8082/docker-local && docker pull 20.102.85.66:8082/docker-local/myapprod:${SHORT_COMMIT}"'
}
