package org.example;

public class Main {
    public static void main(String[] args) {
        Order o1 = new Order(1,"Cash");
        Order o2 = new Order(2,"Tranfer");
        Order o3 = new Order(3,"VNPay");


        System.out.println(o1.getPayment());
        System.out.println(o2.getPayment());
        System.out.println(o3.getPayment());
    }
}