#!/bin/bash
set -ev

# remove pre-installed sdk which is broken (see https://issuetracker.google.com/issues/35906415)
sudo apt-get update
sudo apt-get remove google-cloud-sdk

# If the SDK is not already cached, download it and unpack it
if [ ! -d ${HOME}/google-cloud-sdk ]; then
  curl https://dl.google.com/dl/cloudsdk/channels/rapid/downloads/google-cloud-sdk-159.0.0-linux-x86_64.tar.gz | tar -zxf - -C $HOME;
fi

# install kubectl
gcloud components update kubectl 

