package com.payment;

public class PaymentService {
    
    public PaymentResult getPaymentResult(int paymentRandomNumber){
        return paymentRandomNumber == 1 ? PaymentResult.SUCCESS : PaymentResult.FAILURE;
    }
}
