package com.cpt.payments.pojo;

public class PaymentError {

	
	private  String errorCode;
	private String errorMessage;
	
	public PaymentError() {
		
	}
	
	public PaymentError(String errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	public String getErrorCode() {
		return errorCode;
	}
	
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "PaymentError [errorCode=" + errorCode + ", errorMessage=" + errorMessage + "]";
	}
	
	
	
}
