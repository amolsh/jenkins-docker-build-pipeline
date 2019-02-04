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
  IS_BRANCH_PUBLISH_TRUE = env.BRANCH_PUBLISH
  println IS_BRANCH_PUBLISH_TRUE.getClass()
  echo "I am in test ${TAG}"
  //docker build -t "${IMAGE_NAME}:${TAG}" ${PATH}
  if (IS_BRANCH_PUBLISH_TRUE) {
    echo "I can publish ${IS_BRANCH_PUBLISH_TRUE}"
  } else {
    echo "I can not publish ${IS_BRANCH_PUBLISH_TRUE}"
  }
}
return this
