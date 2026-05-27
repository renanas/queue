package com.renan.queue.application.payment.processor;

import com.renan.queue.domain.Order;

public interface PaymentProcessor {

    void process(Order order);
}
