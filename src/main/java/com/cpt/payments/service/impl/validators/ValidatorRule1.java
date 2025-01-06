package com.cpt.payments.service.impl.validators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.cpt.payments.constant.ErrorCodeEnum;
import com.cpt.payments.dto.PaymentRequestDTO;
import com.cpt.payments.exception.ValidationException;
import com.cpt.payments.service.interfaces.Validator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ValidatorRule1 implements Validator {
  
	private static final Logger log = LoggerFactory.getLogger(ValidatorRule1.class);
	@Override
	public void validate(PaymentRequestDTO paymentRequestDTO) {
		log.info("ValidatorRule1| Validating payment request: {}", paymentRequestDTO);
		
		//TODO Implement validation logic here
		if (paymentRequestDTO.getPayment().getAmount() < 0) {
			log.error("ValidatorRule1| Payment request validation failed. Amount cannot be negative");
			
			ValidationException validationException = new ValidationException(
					ErrorCodeEnum.INVALID_AMOUNT.getErrorCode(), 
					ErrorCodeEnum.INVALID_AMOUNT.getErrorMessage(),
					HttpStatus.BAD_REQUEST);
			
			log.info("Raising validationException: {}", validationException);
			
			throw validationException;//new RuntimeException("Amount cannot be negative");
		}
		
		log.info("ValidatorRule1| Payment request validated successfully");

	}

}
