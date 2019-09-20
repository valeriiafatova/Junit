package com.payment;

public class PaymentService {
    
    public PaymentResult getPaymentResult(int isEnoughMoney){
        return isEnoughMoney == 1 ? PaymentResult.SUCCESS : PaymentResult.FAILURE;
    }
}
