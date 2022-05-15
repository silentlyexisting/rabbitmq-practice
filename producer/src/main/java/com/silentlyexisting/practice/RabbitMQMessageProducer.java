package com.silentlyexisting.practice;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class RabbitMQMessageProducer {

    private final AmqpTemplate amqpTemplate;

    public void publish(Object message, String exchange, String routingKey) {
        log.info("Publishing to {} using routing-key {} with message {}", exchange, routingKey, message);
        amqpTemplate.convertAndSend(exchange, routingKey, message);
        log.info("Published to {} using routing-key {} with message {}", exchange, routingKey, message);
    }
}
