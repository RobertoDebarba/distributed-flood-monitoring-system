# Distributed flood monitoring system

This project is a distributed flood monitoring system. It allows adding new data from new processes, as well as adding new sensors, in an easy way without affecting other processes.

*Esse projecto é um sistema distribuido de monitoramento de enchentes. Permite adicionar novos dados a partir de novos processos, como também adicionar novos sensores, de maneira fácil sem afetar os demais processos.*

![diagram](https://github.com/RobertoDebarba/distributed-flood-monitoring-system/blob/master/specs/architeture_diagram.png)

## Prerequisites

* [RabbitMQ](https://www.rabbitmq.com/) (`$ apt install rabbitmq-server`)
* [MongoDB](https://docs.mongodb.com/manual/tutorial/install-mongodb-on-ubuntu/)
* [JDK 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [Tomcat 8](https://tomcat.apache.org/download-80.cgi)
* [Maven](https://maven.apache.org/)

## How to run server

1. Start MongoDB: `sudo service mongod start`
1. Start RabbitMQ: `sudo service rabbitmq-server start`
1. Build and package project: `mvn package`
1. Run REST API: `java -jar distributed-flood-monitoring-system-api/target/dependency/webapp-runner.jar distributed-flood-monitoring-system-api/target/*.war`
1. Run dam level consumer: `java -jar distributed-flood-monitoring-system-consumer/target/distributed-flood-monitoring-system-consumer-1.0-jar-with-dependencies.jar 1`
1. Run flood gate consumer: `java -jar distributed-flood-monitoring-system-consumer/target/distributed-flood-monitoring-system-consumer-1.0-jar-with-dependencies.jar 2`
1. Run rain fall consumer: `java -jar distributed-flood-monitoring-system-consumer/target/distributed-flood-monitoring-system-consumer-1.0-jar-with-dependencies.jar 3`
1. Run river level consumer: `java -jar distributed-flood-monitoring-system-consumer/target/distributed-flood-monitoring-system-consumer-1.0-jar-with-dependencies.jar 4`

## How to run sensors

1. Start producer module project

## Authors

* [Roberto Luiz Debarba](https://github.com/RobertoDebarba)
* [Matheus Hoeltgebaum Pereira](https://github.com/matheushoeltgebaum)
* [Matheus Adriano Pereira](https://github.com/matheusPereiraKrumm)
