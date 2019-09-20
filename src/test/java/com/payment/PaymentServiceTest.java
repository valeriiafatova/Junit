package com.payment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PaymentServiceTest {

    private PaymentService paymentService;

    @Before
    public void setUp() {
        PaymentService instance = new PaymentService();
    }

    @Test
    public void shouldReturnPaymentResult() {
        assertEquals(PaymentResult.class, paymentService.getPaymentResult().getDeclaringClass());
    }
}