package com.microservice.stockprice.connections;

import constants.RabbitMQConstants;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class RabbitMQConnection {
    private static final String NAME_EXCHANGE = "amq.direct";
    private AmqpAdmin amqpAdmin;

    public RabbitMQConnection(AmqpAdmin amqpAdmin){
        this.amqpAdmin = amqpAdmin;
    }

    private Queue queue(String nameQueue){
        return new Queue(nameQueue, true, false, false);
    }

    private DirectExchange directSwitch(){
        return new DirectExchange(NAME_EXCHANGE);
    }

    private Binding relations(Queue queue, DirectExchange exchange){
        return new Binding(
                queue.getName(),
                Binding.DestinationType.QUEUE,
                exchange.getName(),
                queue.getName(),
                null);
    }

    // execute when server is running
    @PostConstruct
    private void add(){
        Queue stockQueue = this.queue(RabbitMQConstants.STOCK_QUEUE);
        Queue priceQueue = this.queue(RabbitMQConstants.PRICE_QUEUE);

        DirectExchange exchange = this.directSwitch();

        Binding stockRelation =this.relations(stockQueue, exchange);
        Binding priceRelation =this.relations(priceQueue, exchange);

        // create queue in rabbitmq
        this.amqpAdmin.declareQueue(stockQueue);
        this.amqpAdmin.declareQueue(priceQueue);

        this.amqpAdmin.declareExchange(exchange);

        this.amqpAdmin.declareBinding(stockRelation);
        this.amqpAdmin.declareBinding(priceRelation);
    }
}
