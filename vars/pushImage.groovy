def call(){
    sh 'docker login -u admin -p password 20.102.85.66:8082/docker-local'
    sh 'docker tag myapprod 20.102.85.66:8082/docker-local/myapprod'
    sh 'docker push 20.102.85.66:8082/docker-local/myapprod'
    sh 'sshpass -p ShivaJi123123 ssh -t -t -o StrictHostKeyChecking=no Shiva@20.102.85.66 uptime && pwd && docker login -u admin -p password 20.102.85.66:8082/docker-local && docker pull 20.102.85.66:8082/docker-local/myapprod'
    sh 'pwd'
    sh 'docker login -u admin -p password 20.102.85.66:8082/docker-local'
    sh 'docker pull 20.102.85.66:8082/docker-local/myapprod'
}
