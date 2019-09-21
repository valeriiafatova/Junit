package com.payment;

import java.util.Arrays;

public class PaymentService {
    private PaymentSystemService paymentSystemService = new PaymentSystemService();

    public PaymentSystem getPaymentSystem(int systemId) {
        if(!validatePaymentSystemId(systemId)){
            throw new IllegalArgumentException("System is is not valid!!!");
        }

        PaymentSystem paymentSystem = paymentSystemService.getPaymentSystem(systemId);

        if(paymentSystem == null){

            throw new IllegalArgumentException("Could not connect to db");
        }
        return paymentSystem;
    }

    private boolean validatePaymentSystemId(int systemId) {
        return Arrays.asList(PaymentSystem.values())
                .stream()
                .map(PaymentSystem::getSystemId)
                .anyMatch(paymentSystemId -> paymentSystemId.equals(systemId));
    }


    public PaymentResult getPaymentResult(int numRand) {
        return numRand == 1 ? PaymentResult.SUCCESS : PaymentResult.FAILURE;
    }

    public void setPaymentSystemService(PaymentSystemService paymentSystemService) {
        this.paymentSystemService = paymentSystemService;
    }
}