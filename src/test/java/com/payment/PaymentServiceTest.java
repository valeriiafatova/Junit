package com.payment;


import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

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
}

class PaymentSystemServiceStub extends PaymentSystemService{
    @Override
    public PaymentSystem getPaymentSystem(int systemId) {
        return PaymentSystem.APPLE_PAY;
    }
}