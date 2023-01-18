package com.satishkumargithub.rabbitmq.consumer;

import com.satishkumargithub.rabbitmq.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMqJsonConsumer {


    @RabbitListener(queues = {"${rabbitmq.json.queue}"},concurrency = "2")
    public void consumeUserMessage(User user) {
        log.info("Consumed user message  {}", user);

    }


}
