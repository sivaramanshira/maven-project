def call(){
    sh 'docker build -t myappdev --target=dev .'
}
