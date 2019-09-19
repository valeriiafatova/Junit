package com.payment;

public class PaymentService {
    
    public PaymentResult getPaymentResult(int paymentResult){
//        return (int) (Math.random() + 1 ) == 1 ? PaymentResult.SUCCESS : PaymentResult.FAILURE;
        return paymentResult == 1 ? PaymentResult.SUCCESS :
                paymentResult == 0 ? PaymentResult.FAILURE : null;
    }
}
