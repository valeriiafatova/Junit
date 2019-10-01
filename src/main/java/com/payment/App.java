package com.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class App {

    @Autowired
    private PaymentService paymentService;
    @Autowired
    private PriceService priceService;
    @Autowired
    private UserInputService userInputService;
    @Autowired
    private UserViewService userViewService;

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
