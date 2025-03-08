package org.example.State;

public class MoMoPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Thanh toán " + amount + " VND qua MoMo.");
    }
}

