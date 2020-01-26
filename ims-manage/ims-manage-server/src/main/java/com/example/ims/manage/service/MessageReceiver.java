package com.example.ims.manage.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageReceiver {

    @RabbitListener(queuesToDeclare= @Queue("myQueues"))
    public void messageLin(String message){
        log.info("Message : {}",message);
    }
}
