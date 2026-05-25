package com.renan.queue.domain;

import com.renan.queue.domain.enums.OrderStatus;
import com.renan.queue.domain.enums.PaymentType;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

    private String id;
    private String amount;
    private OrderStatus status;
    private PaymentType paymentType;
}
