package com.cpt.payments.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cpt.payments.constant.ErrorCodeEnum;
import com.cpt.payments.pojo.PaymentError;

@ControllerAdvice
public class ValidationExceptionHandler {
     
	private Logger log = LoggerFactory.getLogger(ValidationExceptionHandler.class);
	
	@ExceptionHandler(ValidationException.class)
	 public ResponseEntity<PaymentError> handleCoustomCheckException(ValidationException ex){
		
		
		log.error("______________Validation Exception Occurs: {}",ex);
		
		PaymentError paymentError =new PaymentError(ex.getErrorCode(),ex.getErrorMessage());
		
		log.error("Returning From Validation Handler: {}",paymentError);
		
		return new ResponseEntity<>(paymentError,ex.getHttpStatus());
	}
	
	
	@ExceptionHandler(Exception.class)
	 public ResponseEntity<PaymentError> handleGenericException(Exception ex){
		
		
		log.error("______________Generic Exception Occurs: {}",ex);
		
		PaymentError paymentError =new PaymentError(ErrorCodeEnum.GENERIC_ERROR.getErrorCode(),ErrorCodeEnum.GENERIC_ERROR.getErrorMessage());
		
		log.error("Returning From Validation Handler: {}",paymentError);
		
		return new ResponseEntity<>(paymentError,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}


