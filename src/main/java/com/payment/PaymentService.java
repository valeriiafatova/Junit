package com.payment;

import com.payment.impl.DefaultPaymentSystemService;
import org.apache.log4j.Logger;

import java.util.Arrays;

public class PaymentService {
    private static final Logger LOG = Logger.getLogger(PaymentService.class);
    private PaymentSystemService paymentSystemService;

    public PaymentService(PaymentSystemService paymentSystemService) {
        this.paymentSystemService = paymentSystemService;
    }

    public PaymentSystem getPaymentSystem(int systemId) {
//        if(!validatePaymentSystemId2(systemId)){
//            throw new IllegalArgumentException("System is is not valid!!!");
//        }
        PaymentSystem paymentSystem = null;
        try {
            paymentSystem = paymentSystemService.getPaymentSystem(systemId);
        }catch (IllegalArgumentException e){
            LOG.error("invalid !! ", e);
        }
        
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

    private boolean validatePaymentSystemId2(int systemId) {
        PaymentSystem[] paymentSystems = PaymentSystem.values();
        int length = paymentSystems.length;
        int[] paymentSystemId = new int[length];

        for (int i = 0; i < length; i++) {
            paymentSystemId[i] = paymentSystems[i].getSystemId();
        }

        for (int i = 0; i < length; i++) {
            if (paymentSystemId[i] == systemId) {
                return true;
            }
        }

        return false;
    }

    public PaymentResult getPaymentResult() {
        return (int) (Math.random() + 1) == 1 ? PaymentResult.SUCCESS : PaymentResult.FAILURE;
    }

    public void setPaymentSystemService(DefaultPaymentSystemService paymentSystemService) {
        this.paymentSystemService = paymentSystemService;
    }
}
