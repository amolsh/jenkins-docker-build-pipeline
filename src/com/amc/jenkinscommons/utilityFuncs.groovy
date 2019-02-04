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
  TAG = args.tag ?: "${VERSION}.${env.BUILD_NUMBER}"
  PATH = args.path ?: '.'
  echo "I am in test ${TAG}"
  sh "docker build -t ${IMAGE_NAME}:${TAG}" ${PATH}"
}
return this
