package com.cpt.payments.exception;

import org.springframework.http.HttpStatus;

public class ValidationException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = -358418307230267396L;
	private String errorCode;
    private String errorMessage;
    private HttpStatus httpStatus;
    // Default constructor
    public ValidationException() {
    }

    // Constructor with errorCode and errorMessage
    public ValidationException(String errorCode, String errorMessage, HttpStatus httpStatus) {
        super(errorMessage); // Pass the errorMessage to the RuntimeException constructor
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.httpStatus =httpStatus;
    }

   

    // Getter for errorCode
    public String getErrorCode() {
        return errorCode;
    }

    

    // Getter for errorMessage
    public String getErrorMessage() {
        return errorMessage;
    }

	public HttpStatus getHttpStatus() {
		// TODO Auto-generated method stub
		return httpStatus;
	}

    
}
