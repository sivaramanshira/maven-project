def call(){
    sh 'docker build -t myapprod --target=prod .'
}
