package com.cpt.payments.service.interfaces;

import org.springframework.stereotype.Service;

import com.cpt.payments.dto.PaymentRequestDTO;
import com.cpt.payments.dto.PaymentResponseDTO;

@Service
public interface PaymentService {

	
	 public  PaymentResponseDTO validateAndProcessPayment(PaymentRequestDTO paymentRequest);

         
}
