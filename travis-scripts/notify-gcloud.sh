#!/bin/bash
set -ev

# auth in gcloud
echo $GCLOUD_KEY | base64 --decode > gcloud.json
gcloud auth activate-service-account $GCLOUD_EMAIL --key-file gcloud.json

# get cluster credentials
gcloud container clusters get-credentials cluster-testjee --zone europe-west1-b --project testjee-171310

# hack to force image reload
kubectl set image deployment/hello-node hello-node=docker.io/fsantagostinobietti/testjee
kubectl set image deployment/hello-node hello-node=docker.io/fsantagostinobietti/testjee:latest
