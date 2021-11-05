package com.microservice.stockprice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public void sendMessage(String queueName, Object message){
        try{
            String messageJson = this.objectMapper.writeValueAsString(message);

            this.rabbitTemplate.convertAndSend(queueName, messageJson);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
