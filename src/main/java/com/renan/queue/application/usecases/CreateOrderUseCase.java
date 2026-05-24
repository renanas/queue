package com.renan.queue.application.usecases;

import com.renan.queue.adapters.input.dto.OrderRequest;
import org.springframework.stereotype.Component;

@Component
public interface CreateOrderUseCase {

    void createOrder(OrderRequest orderRequest);
}
