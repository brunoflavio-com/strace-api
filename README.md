# STrace web api #

This is a very simple application, it outputs a number of strace lines for a given process. In a WebApi.

It was built in order to experiment with the sidecar microservices pattern, as explained in the book “Designing Distributed Systems by Brendan Burns (O’Reilly). Copyright 2018 Brendan Burns, 978-1-491-98364-5.”

This was also an experiment to see micronaut.io in action, and I've started with the [Creating your first Micronaut app](http://guides.micronaut.io/creating-your-first-micronaut-app/guide/index.html) guide.

## Build instructions

* `./gradlew assembleShadowDist`
* `docker build --tag=strace-api .`

## To run

* `docker run -p 8080:8080 --cap-add sys_ptrace --cap-add sys_admin strace-api`
