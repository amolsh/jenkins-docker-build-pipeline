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

def dockerBuidPublish(Map args) {
  IMAGE_NAME = args.imagename ?: ''
  VERSION = args.version ?: '1.0'
  TAG = args.tag ?: "${VERSION}.#${env.BUILD_NUMBER}"
  echo "I am in test ${TAG}"
  //docker build -t ${imagename} .
}
return this
