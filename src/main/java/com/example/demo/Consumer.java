package com.example.demo;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;

import static com.example.demo.AppConfig.QUEUE_NAME;

@RabbitListener(queues = QUEUE_NAME)
public class Consumer {
    @RabbitHandler
    public void receive(@Payload String in) throws InterruptedException {
        System.out.println("[x] received string -> '" + in + "'");
        Thread.sleep(5000);
    }
}
