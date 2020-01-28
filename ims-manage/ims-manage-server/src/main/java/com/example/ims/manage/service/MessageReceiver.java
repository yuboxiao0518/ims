package com.example.ims.manage.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class MessageReceiver {

    @RabbitListener(bindings = @QueueBinding(value = @Queue("myQueues"), key = "key", exchange = @Exchange("myExchange")))
    public void messageLin(String message) {
        log.info("Message : {}", message);
    }
}
