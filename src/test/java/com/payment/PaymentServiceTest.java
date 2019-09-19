package com.payment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PaymentServiceTest {
    private PaymentService paymentService;

    @Before
    public void setUp() throws Exception {
        paymentService = new PaymentService();
    }

    @Test
    public void shouldReturnSuccessWhenNumForGenerationResultOne(){
        PaymentResult result = paymentService.getPaymentResult(1);
        assertEquals(PaymentResult.SUCCESS, result);
    }

    @Test
    public void shouldReturnFailureWhenNumForGenerationResultZero(){
        PaymentResult result = paymentService.getPaymentResult(0);
        assertEquals(PaymentResult.FAILURE, result);
    }

    @Test
    public void shouldReturnFailureWhenNumForGenerationResultNegative(){
        PaymentResult result = paymentService.getPaymentResult(-1);
        assertEquals(PaymentResult.FAILURE, result);
    }

    @Test
    public void shouldReturnFailureWhenNumForGenerationResultHigherThanOne(){
        PaymentResult result = paymentService.getPaymentResult(3);
        assertEquals(PaymentResult.FAILURE,result);
    }
}