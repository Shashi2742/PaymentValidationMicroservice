package com.cpt.payments.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.cpt.payments.constant.ValidatorEnum;
import com.cpt.payments.dto.PaymentRequestDTO;
import com.cpt.payments.dto.PaymentResponseDTO;
import com.cpt.payments.service.interfaces.PaymentService;
import com.cpt.payments.service.interfaces.Validator;




@Service
public class PaymentServiceImpl implements PaymentService {

	 
	@Value("${validator.rules}")
	private String validatorRules;
	private ApplicationContext applicationContext;
	
	PaymentServiceImpl(ApplicationContext applicationContext){
		this.applicationContext=applicationContext;
	}
	private static Logger log = LoggerFactory.getLogger("PaymentServiceImpl.class");
	
	
	@Override
	public PaymentResponseDTO validateAndProcessPayment(PaymentRequestDTO paymentRequest) {
		
		/*
		 * String name=null; name.length();
		 */		
		log.info("Payment Request Recieved in PaymentServiceImpl :{}",paymentRequest);
		String[] rules = validatorRules.split(",");
		
		
		
		for(String rule:rules) {
			
			rule = triggerValidationRule(paymentRequest, rule);
			
		}
		
		String txIdn = "TX123";
		String redirect = "www.google.com";
		
		 PaymentResponseDTO paymentResponseDTO=new PaymentResponseDTO(txIdn,redirect);
		
		
		
		
		log.info("Payment request processed successfully. All rules passed");
	 	return paymentResponseDTO;
		
		
	}


	private String triggerValidationRule(PaymentRequestDTO paymentRequestDTO, String rule) {
		rule=rule.trim();
		log.info("Validating Payment request using rule: {}"+rule);
		Validator validator=null;
		
		Class<? extends Validator> validatorClass= (Class<? extends Validator>) ValidatorEnum.getClassByName(rule);
		
		
		
		if(validatorClass != null) {
			validator=applicationContext.getBean(validatorClass);
			
			if(validator != null) {
				log.info("Calling Validator rule: {}", rule);
				validator.validate(paymentRequestDTO);
			}
		}
		if(validatorClass == null || validator ==null) {
			log.error("Either Validator class not found or instance not found for "+"|rule:{} | validatorClass:{} | validator:{}",rule,validatorClass,validator);
		     
		}
		return rule;
	}

}
