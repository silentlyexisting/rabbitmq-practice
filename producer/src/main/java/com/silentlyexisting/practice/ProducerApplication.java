package com.silentlyexisting.practice;

import com.silentlyexisting.practice.config.ProducerConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProducerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(RabbitMQMessageProducer producer, ProducerConfig producerConfig) {
        return args -> {
            producer.publish("Hello RabbitMQ!",
                    producerConfig.getTopicExchangeValue(),
                    producerConfig.getRoutingKeyValue());
        };
    }
}
