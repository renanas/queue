package com.renan.queue.adapters.input.rest;

import com.renan.queue.adapters.input.dto.OrderRequest;
import com.renan.queue.adapters.output.rabbitmq.OrderProducer;
import com.renan.queue.application.usecases.CreateOrderUseCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    private final OrderProducer orderProducer;

    private final CreateOrderUseCase createOrderUseCase;

    public OrderController(OrderProducer orderProducer,
                           CreateOrderUseCase createOrderUseCase
                           ) {
        this.orderProducer = orderProducer;
        this.createOrderUseCase = createOrderUseCase;
    }

    @GetMapping("/order")
    public String sendOrder(){
        orderProducer.sendMessage("Create Order with Success");
        return "Order sent";
    }

    @PostMapping("order")
    public void sendOrderClient(@RequestBody OrderRequest orderRequest){
        createOrderUseCase.createOrder(orderRequest);
    }
}
