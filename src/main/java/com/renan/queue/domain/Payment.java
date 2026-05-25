package com.renan.queue.domain;

import com.renan.queue.domain.enums.PaymentStatus;
import com.renan.queue.domain.enums.PaymentType;

public class Payment {

    private String id;
    private String amount;
    private PaymentType type;
    private PaymentStatus status;

}
