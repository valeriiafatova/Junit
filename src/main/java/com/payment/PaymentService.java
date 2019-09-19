package com.payment;

public class PaymentService {
    
    public PaymentResult getPaymentResult(int numForResultGeneration){
        return numForResultGeneration == 1 ? PaymentResult.SUCCESS : PaymentResult.FAILURE;
    }
}
