def call(){
    sh 'docker build -t myappdev:${SHORT_COMMIT} --target=dev .'
}
