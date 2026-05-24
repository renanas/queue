package com.renan.queue.adapters.input.rabbitmq;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OrderConsumer {

    @RabbitListener(queues = "created-order.queue")
    public void consumeOrder(String message){

        System.out.println("Message received: " + message);

        throw new AmqpRejectAndDontRequeueException(
                "Error processing message"
        );
    }
}