package com.satishkumargithub.rabbitmq.publisher;

import com.satishkumargithub.rabbitmq.dto.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RabbitMqJsonProducer {

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.json.routing.key}")
    private String jsonRoutingKey;

    private final RabbitTemplate rabbitTemplate;


    public void publishJsonMessage(User user) {
        log.info("publish user details {} ", user);
        rabbitTemplate.convertAndSend(exchange, jsonRoutingKey, user);

    }

}
