package com.payment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PriceServiceTest {

    private PriceService priceService;

    @Before
    public void setUp() {
        priceService = new PriceService();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnIllegalArgumentExceptionWhenNotPositiveNumber() {
        priceService.validatePrice(-7);
    }

    @Test
    public void shouldNotReturnThrowIllegalArgumentExceptionWhenPositiveNumber(){
        priceService.validatePrice(5);
    }
}