package com.renan.queue.adapters.output.persistence;

import com.renan.queue.application.ports.output.OrderRepository;
import com.renan.queue.domain.Order;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryAdapter implements OrderRepository {
    @Override
    public void save(Order order) {
        System.out.println("Saved");
    }
}
