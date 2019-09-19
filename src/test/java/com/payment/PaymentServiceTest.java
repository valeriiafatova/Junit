package com.payment;

import com.payment.enums.PaymentResult;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PaymentServiceTest {

    private PaymentService paymentService;

    @Before
    public void setUp() {
        paymentService = new PaymentService();
    }

    @Test
    public void shouldReturnPaymentResult() {
        assertEquals(PaymentResult.class, paymentService.getPaymentResult().getDeclaringClass());
    }
}
