package com.payment;

import org.junit.Before;
import org.junit.Test;

public class PriceServiceTest {

    private PriceService instance;

    @Before
    public void setUp() {
        instance = new PriceService();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnException() {
        instance.validatePrice(-100);
    }

    @Test
    public void shouldRunWithoutException() {
        instance.validatePrice(100);
    }
}