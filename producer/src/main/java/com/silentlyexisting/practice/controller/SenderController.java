package com.silentlyexisting.practice.controller;

import com.silentlyexisting.practice.RabbitMQMessageProducer;
import com.silentlyexisting.practice.config.ProducerConfig;
import com.silentlyexisting.practice.model.Student;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/students")
@AllArgsConstructor
public class SenderController {

    private final RabbitMQMessageProducer messageProducer;
    private final ProducerConfig producerConfig;

    @PostMapping
    public void produceStudent(@RequestBody Student student) {
        messageProducer.publish(student,
                producerConfig.getTopicExchangeValue(),
                producerConfig.getRoutingKeyValue()
                );
    }
}
