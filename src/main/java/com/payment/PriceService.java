package com.payment;

import org.springframework.stereotype.Component;

@Component
public class PriceService {
    
    public void validatePrice(int price){
        if(price <= 0 ){
            throw new IllegalArgumentException("Incorrect total Price");
        }
    }
}
