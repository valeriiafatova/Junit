package com.payment;

import org.junit.Before;
import org.junit.Test;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class PriceServiceTest {

    private PriceService priceService;

    @Before
    public void setUp(){
        priceService = new PriceService();
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenNumberZero() {
        Throwable thrown = catchThrowable(() -> {
            priceService.validatePrice(0);
        });
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
        assertThat(thrown.getMessage()).isNotBlank();
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenNumberLessZero() {
        Throwable thrown = catchThrowable(() -> {
            priceService.validatePrice(-500);
        });
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
        assertThat(thrown.getMessage()).isNotBlank();

    }

    @Test(expected = Test.None.class)
    public void shouldNotThrowExceptionWhenNumberGreaterZero(){
            priceService.validatePrice(500);
    }


}