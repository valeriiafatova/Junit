package com.payment;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class UserInputService {
    
    private Scanner scanner = new Scanner(System.in);
    
    public Integer getUserInput(){
        return Integer.valueOf(scanner.nextLine());
    }
    
}
