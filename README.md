# POC: JAX-RS Hystrix

It demonstrates how to send metrics from a REST API implemented using JAX-RS to Hystrix Dashboard.

## How to run

| Description | Command |
| :--- | :--- |
| Run tests | `./gradlew test` |
| Run the API | `./gradlew run` |
| Send successful requests | `make success` |
| Send failure requests | `make failure` |
