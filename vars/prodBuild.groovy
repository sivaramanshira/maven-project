def call(){
    sh 'docker build -t myapprod:${SHORT_COMMIT} --target=prod .'
}
