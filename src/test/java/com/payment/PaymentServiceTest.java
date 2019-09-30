package com.payment;


import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyInt;

@RunWith(MockitoJUnitRunner.class)
public class PaymentServiceTest {

    @InjectMocks
    private PaymentService instance;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    @Mock
    private PaymentSystemService paymentSystemServiceMock;
    
    private PaymentSystemService paymentSystemServiceStub1 
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
        //MockitoAnnotations.initMocks(instance);
        //instance.setPaymentSystemService(paymentSystemServiceMock);
        Mockito.when(paymentSystemServiceMock.getPaymentSystem(anyInt())).thenReturn(PaymentSystem.GOOGLE_PAY);
        Mockito.when(paymentSystemServiceMock.getPaymentSystem(1)).thenReturn(null);
    }
    
    @Test
    public void shouldReturnPaymentSystemWhenValidPaymentSystemId() {
        PaymentSystem result = instance.getPaymentSystem(2);
        
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