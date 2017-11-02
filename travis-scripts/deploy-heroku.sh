#!/bin/bash
set -ev

# login in heroku registry
docker login --username=_ --password="$HEROKU_REGISTRY_PASSWORD" registry.heroku.com

# pushing image in registry will start a new deploy
docker tag fsantagostinobietti/testjee registry.heroku.com/testjee/web
docker push registry.heroku.com/testjee/web
