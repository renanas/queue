package com.renan.queue.application.usecases;

import com.renan.queue.adapters.input.dto.OrderRequest;
import com.renan.queue.application.ports.input.CreateOrderInputPort;
import com.renan.queue.application.ports.output.OrderRepository;
import com.renan.queue.domain.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class CreateOrderUseCase
        implements CreateOrderInputPort {

    private final OrderRepository orderRepository;

    public CreateOrderUseCase(
            OrderRepository orderRepository
    ){
        this.orderRepository = orderRepository;
    }

    @Override
    public void createOrder(Order order){

        orderRepository.save(order);
    }
}