package com.example.demo;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Send {

    @Autowired
    private RabbitTemplate template;
    @Autowired
    private Queue queue;


    public void simpleSend(String msg) {
        template.convertAndSend(queue.getName(), msg);
    }
}
