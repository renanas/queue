package com.renan.queue.adapters.input.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRequest {

    private String customerId;
    private String amount;
    private String paymentType;
}
