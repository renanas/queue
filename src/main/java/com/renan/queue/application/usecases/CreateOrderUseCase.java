package com.renan.queue.application.usecases;

import com.renan.queue.adapters.input.dto.OrderRequest;
import com.renan.queue.application.payment.factory.PaymentProcessorFactory;
import com.renan.queue.application.payment.factory.PaymentProcessorResolver;
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

    private final PaymentProcessorResolver paymentProcessorResolver;

    public CreateOrderUseCase(
            OrderRepository orderRepository,
            PaymentProcessorResolver paymentProcessorResolver

    ){
        this.orderRepository = orderRepository;
        this.paymentProcessorResolver = paymentProcessorResolver;
    }

    @Override
    public void createOrder(Order order){

        paymentProcessorResolver
                .getProcessor(order.getPaymentType())
                .process(order);

        // TODO: Criar a conxao com o banco

        orderRepository.save(order);


        //TODO: DEPOIS DE SALVAR PRECISO MANDAR UMA MENSAGEM PARA A FILA DE ORDER
    }
}