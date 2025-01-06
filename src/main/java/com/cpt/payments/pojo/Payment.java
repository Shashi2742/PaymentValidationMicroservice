package com.cpt.payments.pojo;

public class Payment {
    private String currency;
    private Double amount;
    private String brandName;
    private String locale;
    private String returnUrl;
    private String cancelUrl;
    private String country;
    private String merchantTxnRef;
    private String paymentMethod;
    private String providerId;
    private String paymentType;

    // Getters and Setters
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public String getCancelUrl() {
        return cancelUrl;
    }

    public void setCancelUrl(String cancelUrl) {
        this.cancelUrl = cancelUrl;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getMerchantTxnRef() {
        return merchantTxnRef;
    }

    public void setMerchantTxnRef(String merchantTxnRef) {
        this.merchantTxnRef = merchantTxnRef;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    // toString method
    @Override
    public String toString() {
        return "Payment{" +
                "currency='" + currency + '\'' +
                ", amount=" + amount +
                ", brandName='" + brandName + '\'' +
                ", locale='" + locale + '\'' +
                ", returnUrl='" + returnUrl + '\'' +
                ", cancelUrl='" + cancelUrl + '\'' +
                ", country='" + country + '\'' +
                ", merchantTxnRef='" + merchantTxnRef + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", providerId='" + providerId + '\'' +
                ", paymentType='" + paymentType + '\'' +
                '}';
    }
}
