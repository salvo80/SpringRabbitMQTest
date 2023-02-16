# SpringRabbitMQTest
Testing integration between Spring REST and RabbitMQ

### Running RabbitMQ
docker run --rm -it -p 15672:15672 -p 5672:5672 rabbitmq:management-alpine

### Running this application
mvn spring-boot:run

### Testing integration
* RabbitMQ Monitoring interface
http://localhost:15672

* Publishing a message
curl -d "an example text that will be added to a queue" http://localhost:8080/push

