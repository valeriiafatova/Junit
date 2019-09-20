package com.payment;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class PaymentServiceTest {

    private PaymentService paymentService;

    @Before
    public void setUp() {
        paymentService = new PaymentService();
    }

    @Test
    public void shouldReturnSuccessWhenIsEnoughMoneyOne(){

        PaymentResult result = paymentService.getPaymentResult(1);
        assertThat(result).isEqualTo(PaymentResult.SUCCESS);
    }

    @Test
    public void shouldReturnFailureWhenIsEnoughMoneyZero(){
        PaymentResult result = paymentService.getPaymentResult(0);
        assertThat(result).isEqualTo(PaymentResult.FAILURE);
    }

    @Test
    public void shouldReturnFailureWhenIsEnoughMoneyZeroLessZero(){
        PaymentResult result = paymentService.getPaymentResult(-500);
        assertThat(result).isEqualTo(PaymentResult.FAILURE);
    }

    @Test
    public void shouldReturnFailureWhenIsEnoughMoneyZeroGreaterOne(){
        PaymentResult result = paymentService.getPaymentResult(500);
        assertThat(result).isEqualTo(PaymentResult.FAILURE);
    }

}