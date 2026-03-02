package com.bytebites.service;

import com.stripe.exception.StripeException;
import com.bytebites.model.PaymentResponse;

public interface PaymentService {
	
	public PaymentResponse generatePaymentLink(Long orderId) throws StripeException;

}
