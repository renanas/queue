package com.renan.queue.application.payment.factory;

import com.renan.queue.application.payment.processor.PaymentProcessor;
import com.renan.queue.domain.enums.PaymentType;

public interface PaymentProcessorResolver {

    PaymentProcessor getProcessor(
            PaymentType paymentType
    );
}
