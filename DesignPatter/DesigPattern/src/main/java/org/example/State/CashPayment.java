package org.example.State;

public class CashPayment implements PaymentMethod{
    @Override
    public void pay(double amount) {
        System.out.println("Thanh toán " + amount + " VND bằng tiền mặt.");
    }
}
