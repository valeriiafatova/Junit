package com.payment;

import org.springframework.stereotype.Service;

@Service(value = "paymentServiceStub")
public class PaymentSystemServiceStub implements PaymentSystemService {
    @Override
    public PaymentSystem getPaymentSystem(int systemId) {
        System.out.println("WE ARE IN STUB");
        return PaymentSystem.APPLE_PAY;
    }
}
