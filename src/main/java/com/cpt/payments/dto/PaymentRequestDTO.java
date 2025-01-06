package com.cpt.payments.dto;

public class PaymentRequestDTO {

    private UserDTO user;
    private PaymentDTO payment;

    // Getters and Setters
    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public PaymentDTO getPayment() {
        return payment;
    }

    public void setPayment(PaymentDTO payment) {
        this.payment = payment;
    }

    // toString Method
    @Override
    public String toString() {
        return "PaymentRequestDTO{" +
                "user=" + user +
                ", payment=" + payment +
                '}';
    }
}
