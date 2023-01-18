package com.satishkumargithub.rabbitmq.controller;

import com.satishkumargithub.rabbitmq.publisher.RabbitMqJsonProducer;
import com.satishkumargithub.rabbitmq.dto.RabbitRequestDto;
import com.satishkumargithub.rabbitmq.dto.ResponseDto;
import com.satishkumargithub.rabbitmq.dto.User;
import com.satishkumargithub.rabbitmq.publisher.RabbitMqPublisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Slf4j
public class RabbitMqController {


    private final RabbitMqPublisher rabbitMqPublisher;

    private final RabbitMqJsonProducer rabbitMqJsonProducer;


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/publish")
    public ResponseDto publishMessage(@RequestBody RabbitRequestDto rabbitRequestDto) {
        rabbitMqPublisher.sendMessage(rabbitRequestDto);
        return new ResponseDto(" Message has been published ");
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/publish/users")
    public ResponseDto publishUserMessage(@RequestBody User user) {
        rabbitMqJsonProducer.publishJsonMessage(user);
        return new ResponseDto(" User details has been published ");
    }


}
