package com.ordertracker.services.payment.strategy;

public enum PaymentType {
    CREDITCARD("CreditCard"),
    DEBITCARD("DebitCard"),
    PAYPAL("PayPal"),;
    private String type;
    PaymentType(String type) {
        this.type = type;
    }
}
