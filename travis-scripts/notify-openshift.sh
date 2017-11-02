#!/bin/bash
set -ev

oc login https://api.starter-us-west-2.openshift.com --token=$OPENSHIFT_TOKEN
oc import-image testjee --all=true
