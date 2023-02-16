package com.example.demo;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
@ComponentScan("com.example.demo")
public class AppConfig {
    public final static String QUEUE_NAME = "QUEUE1";
    @Bean
    public Queue getQueue1(){
        return new Queue(QUEUE_NAME);
    }
    @Bean
    public ConnectionFactory getConnectionFactory(){
        return new CachingConnectionFactory();
    }
    @Bean
    public RabbitTemplate getTemplate(ConnectionFactory cf){
        return new RabbitTemplate(cf);
    }
    @Bean
    public SimpleRabbitListenerContainerFactory myRabbitListenerContainerFactory(ConnectionFactory cf) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(cf);
        factory.setMaxConcurrentConsumers(5);
        return factory;
    }
    @Bean
    public Consumer receiver() {
        return new Consumer();
    }
}
