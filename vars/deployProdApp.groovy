def call(){
    sh 'sshpass -p ShivaJi123123 ssh -t -t -o StrictHostKeyChecking=no Shiva@10.1.2.4 "docker run -d -p 9092:8080 20.102.85.66:8082/docker-local/myapprod:${SHORT_COMMIT}"'
}
