package com.renan.queue.application.ports.output;

import com.renan.queue.domain.Order;

public interface OrderRepository {

    void save(Order order);
}
