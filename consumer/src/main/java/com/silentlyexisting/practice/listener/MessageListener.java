package com.silentlyexisting.practice.listener;

import com.silentlyexisting.practice.dto.StudentDto;
import com.silentlyexisting.practice.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

    @RabbitListener(queues = "${rabbitmq.queues.queue}")
    public void listen(StudentDto studentDto) {
        log.info("-> Consumed message {} from queue", studentDto);
        service.createNewStudent(studentDto);
    }

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
