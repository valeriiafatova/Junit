package com.payment.impl;

import com.payment.PaymentSystem;
import com.payment.PaymentSystemService;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DefaultPaymentSystemService implements PaymentSystemService {
    
    public PaymentSystem getPaymentSystem3(int systemId){
        PaymentSystem[] values = PaymentSystem.values();
        PaymentSystem result = null;
        for(int i = 0 ; i <values.length ; i ++ ) {
            if(values[i].getSystemId() == systemId){
                result = values[i];
            }
        }
        return result;
    }

    public PaymentSystem getPaymentSystem2(int systemId){
        PaymentSystem[] values = PaymentSystem.values();
        PaymentSystem result = null;
        for (PaymentSystem value : values) {
            if (value.getSystemId() == systemId) {
                result = value;
            }
        }
        return result;
    }

    @Override
    public PaymentSystem getPaymentSystem(int systemId) {
        List<PaymentSystem> paymentSystems = Arrays.asList(PaymentSystem.values());
        return paymentSystems.stream()
                .filter(paymentSystem -> paymentSystem.getSystemId() == systemId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Wrong system id!"));
    }
}
