package com.payment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PaymentServiceTest {

    private PaymentService paymentService;

    @Before
    public void setUp() {
        paymentService = new PaymentService();
    }

    @Test
    public void shouldReturnSuccessWhenOne() {
        assertEquals(PaymentResult.SUCCESS, paymentService.getPaymentResult(1));
    }

    @Test
    public void shouldReturnFailureWhenZero() {
        assertEquals(PaymentResult.FAILURE, paymentService.getPaymentResult(0));
    }

    @Test
    public void shouldReturnNullWhenNotOneAndNotTwo() {
        assertNull(paymentService.getPaymentResult(30));
    }

}