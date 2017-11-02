#!/bin/bash
set -ev

oc login https://api.starter-us-west-2.openshift.com --username=$OPENSHIFT_USERNAME  --password=$OPENSHIFT_PASSWORD
oc import-image testjee --all=true
