package com.satishkumargithub.rabbitmq.publisher;

import com.satishkumargithub.rabbitmq.dto.RabbitRequestDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RabbitMqPublisher {

    @Value("${rabbitmq.exchange.name}")
    @Getter
    @Setter
    private String exchange;

    @Value("${rabbitmq.routing.key}")
    @Getter
    @Setter
    private String routingKey;

    /*
     * Let us use RabbitmqTemplate to send the message
     * Spring boot automatically configure RabbitmqTemplate for us
     *
     */

    private final RabbitTemplate rabbitTemplate;


    public void sendMessage(RabbitRequestDto rabbitRequestDto) {

        String message = rabbitRequestDto.getMessage();
        log.info(" Publish Message: {}", message);
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
    }


}
