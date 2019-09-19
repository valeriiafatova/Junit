package com.payment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PriceServiceTest {
    private PriceService priceService;

    @Before
    public void setUp() throws Exception {
        priceService = new PriceService();
    }

    @Test
    public void shouldNotThrowExceptionWhenPositiveNumber(){
        try {
            priceService.validatePrice(5);
        } catch (IllegalArgumentException ex){
            fail("Validate price method thrown exception when price is positive number");
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionWhenZeroNumber(){
            priceService.validatePrice(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionWhenNegativeNumber(){
        priceService.validatePrice(-3);
    }
}