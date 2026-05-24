package com.renan.queue.application.ports.interfaces;

import com.renan.queue.domain.Order;

public interface OrderRepository {

    void save(Order order);
}
