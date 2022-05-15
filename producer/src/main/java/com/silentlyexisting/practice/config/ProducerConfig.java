package com.silentlyexisting.practice.config;

import lombok.Getter;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class ProducerConfig {

    // set up the topic exchange, queue with routing-key and bind it

    @Value("${rabbitmq.exchanges.topic-exchange}")
    private String topicExchangeValue;

    @Value("${rabbitmq.queues.queue}")
    private String queueValue;

    @Value("${rabbitmq.routing-keys.key}")
    private String routingKeyValue;

    @Bean
    public TopicExchange topic() {
        return new TopicExchange(this.topicExchangeValue);
    }

    @Bean
    public Queue queue() {
        return new Queue(this.queueValue, false);
    }

    @Bean
    public Binding bind() {
        return BindingBuilder
                .bind(queue())
                .to(topic())
                .with(this.routingKeyValue);
    }
}

