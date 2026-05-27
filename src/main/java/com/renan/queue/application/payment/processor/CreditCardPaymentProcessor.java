package com.renan.queue.application.payment.processor;

import com.renan.queue.domain.Order;
import org.springframework.stereotype.Component;

@Component
public class CreditCardPaymentProcessor implements PaymentProcessor {

    @Override
    public void process(Order order){

        System.out.println("Processing credit card");

    }
}
