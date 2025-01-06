package com.cpt.payments.controller;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web. bind.annotation.RestController;

import com.cpt.payments.constant.EndPoints;
import com.cpt.payments.dto.PaymentRequestDTO;
import com.cpt.payments.dto.PaymentResponseDTO;
import com.cpt.payments.pojo.PaymentRequest;
import com.cpt.payments.pojo.PaymentResponse;
import com.cpt.payments.service.interfaces.PaymentService;




@RestController
@RequestMapping(EndPoints.V1_PAYMENTS)
public class PaymentController {
	
	private PaymentService paymentService;
	
	private ModelMapper modelMapper;

	public PaymentController() {
		
	}

	 @Autowired
	 PaymentController(PaymentService paymentService, ModelMapper modelMapper) {
		this.paymentService=paymentService;
		this.modelMapper=modelMapper;
		
	}
	
	
	private  static Logger log = LoggerFactory.getLogger(PaymentController.class);

	@PostMapping
	public ResponseEntity<PaymentResponse> createPayment(@RequestBody PaymentRequest paymentRequest) {  
		log.info("Payment Request Recived in Controller : {}", paymentRequest); 
		
		PaymentRequestDTO paymentRequestDTO=modelMapper.map(paymentRequest,PaymentRequestDTO.class);
		
		PaymentResponseDTO response =paymentService.validateAndProcessPayment(paymentRequestDTO);
		
		PaymentResponse paymentResponse= modelMapper.map(response,PaymentResponse.class);
		
		log.info("Returning Response From PaymentController : {}", paymentResponse);
		
		
		
		return  new ResponseEntity<>(paymentResponse,HttpStatus.OK);
	}
}
