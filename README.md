# SpringRabbitMQTest
Testing integration between Spring REST and RabbitMQ. You can add messages to queue calling endpoint /push. Messages will be automatically consumed at rate of 1 every 5 seconds.

### Running RabbitMQ
docker run --rm -it -p 15672:15672 -p 5672:5672 rabbitmq:management-alpine

### Running this application
mvn spring-boot:run

### Testing integration
* Publish a message with -> curl -d "an example text that will be added to a queue" http://localhost:8080/push
* Open application log and look for something like "[x] received string -> ... "

### Bonus
* Check RabbitMQ monitoring interface -> http://localhost:15672
