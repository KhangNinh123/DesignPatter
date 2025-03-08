package org.example.State;

public class BankTransferPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Thanh toán " + amount + " VND qua chuyển khoản ngân hàng.");
    }
}
