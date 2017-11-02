#!/bin/bash
set -ev

curl -L https://mirror.openshift.com/pub/openshift-v3/clients/3.5.5.10/linux/oc.tar.gz | sudo tar -f - -x -z  -C /usr/bin/ oc
