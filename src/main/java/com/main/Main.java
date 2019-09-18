package com.main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How you want to pay?\n" +
                "1.ApplePay\n" +
                "2.GooglePay\n" +
                "3.Visa\n");

        int systemId = scanner.nextInt();
        String system;

        switch (systemId) {
            case 1:
                system = "ApplePay";
                break;
            case 2:
                system = "GooglePay";
                break;
            case 3:
                system = "Visa";
                break;
            default:
                throw new IllegalArgumentException("Wrong system");
        }

        System.out.println("Enter total price: ");
        int price = scanner.nextInt();

        if(price <= 0 ){
            throw new IllegalArgumentException("Incorrect total Price");
        }

        System.out.println("Sending request to " + system);
        String result = (int) (Math.random() + 1.5 ) == 1 ? "Success" : "Failure";

        System.out.println("Result is: " + result);

    }
}
