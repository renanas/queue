package com.renan.queue.application.ports.input;

import com.renan.queue.adapters.input.dto.OrderRequest;
import com.renan.queue.application.ports.interfaces.OrderRepository;
import com.renan.queue.application.usecases.CreateOrderUseCase;
import com.renan.queue.domain.Order;

public class CreateOrderInputPort implements CreateOrderUseCase {

    private final OrderRepository orderRepository;

    private CreateOrderInputPort(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    @Override
    public void createOrder(OrderRequest orderRequest) {
        Order order = new Order();
        orderRepository.save(order);
    }
}
