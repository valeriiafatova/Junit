package com.payment;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PriceServiceTest {

    private PriceService instance;

    @Before
    public void setUp() {
        instance = new PriceService();
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void shouldThrowExceptionWhenPriceNegative() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Incorrect total Price");
        instance.validatePrice(-1);
    }

    @Test
    public void shouldThrowExceptionWhenPriceZero() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Incorrect total Price");
        instance.validatePrice(0);
    }

    @Test
    public void shouldNotThrowExceptionWhenPricePositive() {
        instance.validatePrice(1);
    }
}