package com.renan.queue.adapters.output.persistence.mapper;

import com.renan.queue.adapters.output.persistence.entities.OrderEntity;
import com.renan.queue.domain.Order;

public class OrderMapper {

    public OrderEntity toEntity(Order order) {

        OrderEntity entity = new OrderEntity();

        entity.setId(order.getId());
        entity.setAmount(order.getAmount());
        entity.setStatus(order.getStatus());
        entity.setPaymentType(order.getPaymentType());

        return entity;
    }
}
