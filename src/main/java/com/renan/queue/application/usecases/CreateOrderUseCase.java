package com.renan.queue.application.usecases;

import com.renan.queue.adapters.input.dto.OrderRequest;
import com.renan.queue.application.payment.factory.PaymentProcessorFactory;
import com.renan.queue.application.payment.processor.PaymentProcessor;
import com.renan.queue.application.ports.input.CreateOrderInputPort;
import com.renan.queue.application.ports.output.OrderRepository;
import com.renan.queue.domain.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class CreateOrderUseCase
        implements CreateOrderInputPort {

    private final OrderRepository orderRepository;

    private final PaymentProcessorFactory paymentProcessorFactory;

    public CreateOrderUseCase(
            OrderRepository orderRepository,
            PaymentProcessorFactory paymentProcessorFactory

    ){
        this.orderRepository = orderRepository;
        this.paymentProcessorFactory = paymentProcessorFactory;
    }

    @Override
    public void createOrder(Order order){

        paymentProcessorFactory
                .getProcessor(order.getPaymentType())
                .process(order);

        orderRepository.save(order);
    }
}