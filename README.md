[![Build Status](https://travis-ci.org/fsantagostinobietti/testJEE.svg?branch=master)](https://travis-ci.org/fsantagostinobietti/testJEE)  [![Coverage Status](https://coveralls.io/repos/github/fsantagostinobietti/testJEE/badge.svg?branch=master)](https://coveralls.io/github/fsantagostinobietti/testJEE?branch=master)  [![Codacy Badge](https://api.codacy.com/project/badge/Grade/418e2be13226431ba982b681e19a9223)](https://www.codacy.com/app/fabio-santagostinobietti/testJEE?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=fsantagostinobietti/testJEE&amp;utm_campaign=Badge_Grade)

# Hi all from Santa

Simple JEE web app used to test Continuous Integration strategies. 

## Local build, test and deploy steps
* unit tests (w/ code coverage report)
```
$ mvn test
```
* build maven project with:
```
$ mvn package
```
* build docker image
```
$ docker build -t testjee .
```
* run ephemeral docker container
```
$ docker run --rm -it -p 8080:8080 testjee
```
* point your browser to [http://localhost:8080/testJEE/](http://localhost:8080/testJEE/) and see a welcome page

## Continuos Integration
Build, unit test, functional test and deploy on [Heroku](https://dashboard.heroku.com/apps/testjee) and [Openshift](https://console.starter-us-west-2.openshift.com/console/project/testjee/overview).

See **.travis.yml** file.


## Access deployed app

Access TEST environment pointing your browser to:
* [http://testjee.herokuapp.com/testJEE/?lang=uk](http://testjee.herokuapp.com/testJEE/?lang=uk)

Access QA environment pointing your browser to: 

* [http://main-testjee.7e14.starter-us-west-2.openshiftapps.com/testJEE/?lang=uk](http://main-testjee.7e14.starter-us-west-2.openshiftapps.com/testJEE/?lang=uk).
