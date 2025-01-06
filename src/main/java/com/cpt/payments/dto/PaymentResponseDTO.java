package com.cpt.payments.dto;

public class PaymentResponseDTO {

    private String txnId;
    private String redirectUrl;

    // No-argument Constructor
    public PaymentResponseDTO() {
    }

    // Parameterized Constructor
    public PaymentResponseDTO(String txnId, String redirectUrl) {
        this.txnId = txnId;
        this.redirectUrl = redirectUrl;
    }

    // Getters and Setters
    public String getTxnId() {
        return txnId;
    }

    public void setTxnId(String txnId) {
        this.txnId = txnId;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    // toString Method
    @Override
    public String toString() {
        return "PaymentResponseDTO{" +
                "txnId='" + txnId + '\'' +
                ", redirectUrl='" + redirectUrl + '\'' +
                '}';
    }
}
