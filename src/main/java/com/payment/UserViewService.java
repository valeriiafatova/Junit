package com.payment;

import org.springframework.stereotype.Component;

@Component
public class UserViewService {
    
    public void showMessage(String message){
        System.out.println(message);
    }
}
