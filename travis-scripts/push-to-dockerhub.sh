#!/bin/bash
set -ev

# push image in Docker Hub registry
docker login -u="$DOCKER_USERNAME" -p="$DOCKER_PASSWORD"
docker push fsantagostinobietti/testjee
