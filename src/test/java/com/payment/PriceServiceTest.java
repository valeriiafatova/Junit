package com.payment;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PriceServiceTest {

    @Rule
    public ExpectedException expectedExceptionRule = ExpectedException.none();

    private PriceService priceServiceInstace;

    @Before
    public void setUp() {
        priceServiceInstace = new PriceService();
    }

    @Test
    public void shouldReturnException() {
        expectedExceptionRule.expect(IllegalArgumentException.class);
        priceServiceInstace.validatePrice(-100);
    }

    @Test
    public void shouldRunWithoutException() {
        priceServiceInstace.validatePrice(100);
    }
}
