package com.payment;

import java.util.Random;

public class App {

    private PaymentService paymentService;
    private PaymentSystemService paymentSystemService;
    private PriceService priceService;
    private UserInputService userInputService;
    private UserViewService userViewService;

    public static void main(String[] args) {
        App app = new App();
        
        app.setPaymentService(new PaymentService());
        app.setPaymentSystemService(new PaymentSystemService());
        app.setPriceService(new PriceService());
        app.setUserInputService(new UserInputService());
        app.setUserViewService(new UserViewService());
        
        app.processPayment();
    }

    public void processPayment() {
        userViewService.showMessage("How you want to pay?\n1.ApplePay\n2.GooglePay\n3.Visa\n");

        Integer systemId = userInputService.getUserInput();
        PaymentSystem system = paymentService.getPaymentSystem(systemId);

        userViewService.showMessage("Enter total price: ");
        Integer price = userInputService.getUserInput();

        priceService.validatePrice(price);

        userViewService.showMessage("Sending request to " + system);

        int numRand = getRandomNumb();
        PaymentResult result = paymentService.getPaymentResult(numRand);

        userViewService.showMessage("Result is: " + result.getResult());
    }

    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void setPaymentSystemService(PaymentSystemService paymentSystemService) {
        this.paymentSystemService = paymentSystemService;
    }

    public int getRandomNumb(){
        Random random = new Random();
        return random.ints(0,(1+1)).findFirst().getAsInt();
    }

    public void setPriceService(PriceService priceService) {
        this.priceService = priceService;
    }

    public void setUserInputService(UserInputService userInputService) {
        this.userInputService = userInputService;
    }

    public void setUserViewService(UserViewService userViewService) {
        this.userViewService = userViewService;
    }
}
