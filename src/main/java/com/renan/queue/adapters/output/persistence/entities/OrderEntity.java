package com.renan.queue.adapters.output.persistence.entities;

import com.renan.queue.domain.enums.OrderStatus;
import com.renan.queue.domain.enums.PaymentType;
import jakarta.persistence.*;
import lombok.Setter;

@Entity
@Table(name = "orders")
@Setter
public class OrderEntity {
    @Id
    private String id;

    private String amount;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;
}
