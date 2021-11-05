package com.microservice.consumerstock.consumer;

import constants.RabbitMQConstants;
import dto.StockDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class StockConsumer {
    @RabbitListener(queues = RabbitMQConstants.STOCK_QUEUE)
    private void consumer(StockDto dto){
        System.out.println("--------ESTOQUE--------------");
        System.out.println("codigo :"+ dto.codProduct);
        System.out.println("quantidade :"+ dto.quantity);
        System.out.println("----------------------");
    }
}
