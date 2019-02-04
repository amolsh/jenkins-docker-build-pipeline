package com.amc.jenkinscommons;

def build() {
  echo "I am in build"
}
def test(name) {
  echo "I am in test ${name}"
}
def deploy(env,app) {
  echo "I am in test ${env}_${app}"
}

def dockerBuidPublish(String ... args) {
  ENV = args['environment'] ?: 'dev'
  echo "I am in test ${ENV}"
  //docker build -t ${imagename} .
}
return this
