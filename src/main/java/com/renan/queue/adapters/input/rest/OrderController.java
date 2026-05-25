package com.renan.queue.adapters.input.rest;

import com.renan.queue.adapters.input.dto.OrderRequest;
import com.renan.queue.adapters.output.rabbitmq.OrderProducer;
import com.renan.queue.application.ports.input.CreateOrderInputPort;
import com.renan.queue.application.usecases.CreateOrderUseCase;
import com.renan.queue.domain.Order;
import com.renan.queue.domain.enums.PaymentType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    private final OrderProducer orderProducer;

    private final CreateOrderInputPort createOrderInputPort;

    public OrderController(OrderProducer orderProducer,
                           CreateOrderInputPort createOrderInputPort
                           ) {
        this.orderProducer = orderProducer;
        this.createOrderInputPort = createOrderInputPort;
    }

    @GetMapping("/order")
    public String sendOrder(){
        orderProducer.sendMessage("Create Order with Success");
        return "Order sent";
    }

    @PostMapping("/order")
    public void sendOrderClient(@RequestBody OrderRequest orderRequest){

        Order order = Order.builder()
                .id(orderRequest.getCustomerId())
                .amount(orderRequest.getAmount())
                .paymentType(PaymentType.valueOf(orderRequest.getPaymentType()))
                .build();

        createOrderInputPort.createOrder(order);
    }
}
