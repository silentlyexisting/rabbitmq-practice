package com.silentlyexisting.practice.listener;

import com.silentlyexisting.practice.dto.StudentDto;
import com.silentlyexisting.practice.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class MessageListener {

    private final StudentService service;

    @RabbitListener(
            bindings =
            @QueueBinding(
                    value = @Queue(value = "${rabbitmq.queues.queue}"),
                    exchange = @Exchange(value = "${rabbitmq.exchanges.topic-exchange}", type = ExchangeTypes.TOPIC)
            )
    )
    public void listen(StudentDto studentDto) {
        log.info("-> Consumed message {} from queue", studentDto);
        service.createNewStudent(studentDto);
    }

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

}
