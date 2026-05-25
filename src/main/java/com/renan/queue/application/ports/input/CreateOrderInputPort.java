package com.renan.queue.application.ports.input;

import com.renan.queue.domain.Order;

public interface CreateOrderInputPort {

    void createOrder(Order order);

}
