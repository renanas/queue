package com.renan.queue.application.payment.factory;

import com.renan.queue.application.payment.processor.BoletoPaymentProcessor;
import com.renan.queue.application.payment.processor.CreditCardPaymentProcessor;
import com.renan.queue.application.payment.processor.PaymentProcessor;
import com.renan.queue.application.payment.processor.PixPaymentProcessor;
import com.renan.queue.domain.Order;
import com.renan.queue.domain.enums.PaymentType;
import org.springframework.stereotype.Component;

@Component
public class PaymentProcessorFactory {

    private final CreditCardPaymentProcessor creditCardProcessor;
    private final PixPaymentProcessor pixProcessor;
    private final BoletoPaymentProcessor boletoProcessor;

    public PaymentProcessorFactory(CreditCardPaymentProcessor creditCardProcessor, PixPaymentProcessor pixProcessor, BoletoPaymentProcessor boletoProcessor) {
        this.creditCardProcessor = creditCardProcessor;
        this.pixProcessor = pixProcessor;
        this.boletoProcessor = boletoProcessor;
    }

    public PaymentProcessor getProcessor(
            PaymentType paymentType
    ) {
        switch (paymentType){
            case CREDIT_CARD -> {
                return creditCardProcessor;
            }
            case PIX -> {
                return pixProcessor;
            }
            case BOLETO -> {
                return boletoProcessor;
            }
        }

        throw new IllegalArgumentException("Payment Type not acceptable");
    }
}
