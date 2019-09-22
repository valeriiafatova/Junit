package com.payment;


import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PaymentServiceTest {

    private PaymentService instance = new PaymentService();

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private PaymentSystemService paymentSystemServiceStub
            = new PaymentSystemService(){
        @Override
        public PaymentSystem getPaymentSystem(int systemId) {
            return systemId == 1 ? null : PaymentSystem.GOOGLE_PAY;
        }
    };

    private PaymentSystemService getPaymentSystemServiceStub2
            = new PaymentSystemServiceStub();

    @Before
    public void setUp() {
        instance.setPaymentSystemService(paymentSystemServiceStub);
    }

    @Test
    public void shouldReturnPaymentSystemWhenValidPaymentSystemId() {
        PaymentSystem result = instance.getPaymentSystem(1);
        assertNotNull(result);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenPaymentSystemIdNotValid() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("System is is not valid!!!");
        instance.getPaymentSystem(0);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenPaymentSystemIsNull() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Could not connect to db");

        instance.getPaymentSystem(1);
    }



    // My home work 3

    @Test
    public void shouldReturnSuccessWhenNumForGenerationResultOne(){
        PaymentResult result = instance.getPaymentResult(1);
        assertEquals(PaymentResult.SUCCESS, result);
    }

    @Test
    public void shouldReturnFailureWhenNumForGenerationResultZero(){
        PaymentResult result = instance.getPaymentResult(0);
        assertEquals(PaymentResult.FAILURE, result);
    }

    @Test
    public void shouldReturnFailureWhenNumForGenerationResultNegative(){
        PaymentResult result = instance.getPaymentResult(-1);
        assertEquals(PaymentResult.FAILURE, result);
    }

    @Test
    public void shouldReturnFailureWhenNumForGenerationResultHigherThanOne(){
        PaymentResult result = instance.getPaymentResult(3);
        assertEquals(PaymentResult.FAILURE,result);
    }
}

class PaymentSystemServiceStub extends PaymentSystemService{
    @Override
    public PaymentSystem getPaymentSystem(int systemId) {
        return PaymentSystem.APPLE_PAY;
    }
}