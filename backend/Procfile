web:    java $JAVA_OPTS -jar distributed-flood-monitoring-system-api/target/dependency/webapp-runner.jar --port $PORT distributed-flood-monitoring-system-api/target/*.war
consumer_damlevel:    java $JAVA_OPTS -jar distributed-flood-monitoring-system-consumer/target/distributed-flood-monitoring-system-consumer-1.0-jar-with-dependencies.jar 1 --port $PORT
consumer_floodgate:    java $JAVA_OPTS -jar distributed-flood-monitoring-system-consumer/target/distributed-flood-monitoring-system-consumer-1.0-jar-with-dependencies.jar 2 --port $PORT
consumer_rainfall:    java $JAVA_OPTS -jar distributed-flood-monitoring-system-consumer/target/distributed-flood-monitoring-system-consumer-1.0-jar-with-dependencies.jar 3 --port $PORT
consumer_riverlevel:    java $JAVA_OPTS -jar distributed-flood-monitoring-system-consumer/target/distributed-flood-monitoring-system-consumer-1.0-jar-with-dependencies.jar 4 --port $PORT
