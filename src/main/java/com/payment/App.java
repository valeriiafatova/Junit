package com.payment;

import com.payment.impl.DefaultPaymentSystemService;

public class App {

    private PaymentService paymentService = new PaymentService(new DefaultPaymentSystemService());
    private PriceService priceService = new PriceService();
    private UserInputService userInputService = new UserInputService();
    private UserViewService userViewService = new UserViewService();

    public static void main(String[] args) {
        App app = new App();
        
        app.setPaymentService(new PaymentService(new DefaultPaymentSystemService()));
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
        
        PaymentResult result = paymentService.getPaymentResult();

        userViewService.showMessage("Result is: " + result.getResult());
    }

    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
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
