package com.payment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PaymentServiceTest {

    private PaymentService instance = new PaymentService();

    private PaymentSystemService paymentSystemServiceStub = new PaymentSystemService(){
        @Override
        public PaymentSystem getPaymentSystem(int systemId) {
            return PaymentSystem.APPLE_PAY;
        }
    };

    @Before
    public void setUp() {
        PaymentService instance = new PaymentService();
        instance.setPaymentSystemService(paymentSystemServiceStub);
    }

    @Test
    public void shouldShowSuccess() {
        assertEquals(instance.getPaymentResult(1), PaymentResult.SUCCESS);
    }

    @Test
    public void shouldShowFailure() {
        assertEquals(instance.getPaymentResult(0), PaymentResult.FAILURE);
    }

}