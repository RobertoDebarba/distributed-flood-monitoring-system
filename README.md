# Clima Alerta - Distributed flood monitoring system

Clima Alerta is a micro service flood monitoring system. It allows adding new data from new processes, as well as adding new sensors, in an easy way without affecting other processes with zero down time.

## Main features

* Friendly user interface based on dashboards
* AccuWather integration
* Flood, rainfall and river level data with status and historic
* Getting in touch with email integration
* Built in client dashboard made with Angular
* Built in data source for mock data
* Built in data source for CEOPS integration
* Plugable clients via REAST APIs
* Plugable data sources (producers) via AMQP Broker
* Micro services based system
* Scalable and resilient services
* Zero down time update

### Dashboard

![diagram](https://github.com/RobertoDebarba/distributed-flood-monitoring-system/blob/master/specs/prints/print1.png)
![diagram](https://github.com/RobertoDebarba/distributed-flood-monitoring-system/blob/master/specs/prints/print2.png)
![diagram](https://github.com/RobertoDebarba/distributed-flood-monitoring-system/blob/master/specs/prints/print3.png)
![diagram](https://github.com/RobertoDebarba/distributed-flood-monitoring-system/blob/master/specs/prints/print4.png)

## Architecture diagram

![diagram](https://github.com/RobertoDebarba/distributed-flood-monitoring-system/blob/master/specs/architeture_diagram.png)

## Prerequisites

* [RabbitMQ](https://www.rabbitmq.com/) (`$ apt install rabbitmq-server`)
* [MongoDB](https://docs.mongodb.com/manual/tutorial/install-mongodb-on-ubuntu/)
* [JDK 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [Maven](https://maven.apache.org/)
* [Node 6.9.0](https://nodejs.org/en/)
* [NPM 3.0.0](https://www.npmjs.com/)

## How to run server

### REST API (distributed-flood-monitoring-system-api)

1. Start MongoDB: `sudo service mongod start`
1. Build and package project: `mvn package`
1. Run: `java -Demail=<email server user> -Dpassword=<email server password> -DsendTo=<email recipient for getting in touch> -jar distributed-flood-monitoring-system-api/target/dependency/webapp-runner.jar distributed-flood-monitoring-system-api/target/*.war`

### Data consumer (distributed-flood-monitoring-system-consumer)

1. Start MongoDB: `sudo service mongod start`
1. Start RabbitMQ: `sudo service rabbitmq-server start`
1. Build and package project: `mvn package`
1. Run: `java -DconsumerType=riverlevel;flood;rainfall -jar distributed-flood-monitoring-system-consumer/target/distributed-flood-monitoring-system-consumer-1.0-jar-with-dependencies.jar`

### Mock data producer (distributed-flood-monitoring-system-producer)

1. Start RabbitMQ: `sudo service rabbitmq-server start`
1. Build and package project: `mvn package`
1. Run: `java distributed-flood-monitoring-system-consumer/target/distributed-flood-monitoring-system-producer-1.0-jar-with-dependencies.jar`
1. Fill in the required information.

### Data producer via CEOPS integration (distributed-flood-monitoring-system-producer-ceops)

1. Start RabbitMQ: `sudo service rabbitmq-server start`
1. Build and package project: `mvn package`
1. Run: `java -DfloodHistoryCron="0 * * * * *" -Ddelay=60000 distributed-flood-monitoring-system-consumer/target/distributed-flood-monitoring-system-producer-ceops-1.0-jar-with-dependencies.jar`
    1. floodHistoryCron is a cron for get flood history.
    11. delay is the time in milliseconds for get river level.

### Dashboard client (frontend)

1. npm install
1. npm start

## Authors

* [Roberto Luiz Debarba](https://github.com/RobertoDebarba)
* [Matheus Hoeltgebaum Pereira](https://github.com/matheushoeltgebaum)
* [Matheus Adriano Pereira](https://github.com/matheusPereiraKrumm)
