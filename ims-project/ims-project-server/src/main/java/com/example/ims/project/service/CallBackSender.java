package com.example.ims.project.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class CallBackSender implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnCallback {

    private final RabbitTemplate rabbitTemplate;

    public void sender(String exchange,String routingKey,String object){
        rabbitTemplate.setConfirmCallback(this);
        CorrelationData correlationData = new CorrelationData(String.valueOf(object.hashCode()));
        rabbitTemplate.convertAndSend(exchange,routingKey,object,correlationData);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        if(b){
            log.info("消息发送成功：{}"+correlationData);
        }else{
            log.error("消息发送失败：{}"+s);
        }

    }

    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        log.info("return--message:" + new String(message.getBody()) + ",replyCode:" + replyCode
                + ",replyText:" + replyText + ",exchange:" + exchange + ",routingKey:" + routingKey);
    }
}
