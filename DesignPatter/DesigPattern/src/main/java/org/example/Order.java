package org.example;

public class Order {
    private int orderID;
    private String payment;

    public Order(int orderID, String payment) {
        this.orderID = orderID;
        this.payment = payment;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getPayment() {
        if(payment=="Cash"){
            return "Thanh Toan Bang Tien Mat";
        } else if(payment=="Tranfer"){
            return "Thanh Toan Bang Chuyen Khoan";
        }else if(payment=="VNPay"){
            return "Thanh Toan Bang VN Pay";
        }
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }


}
