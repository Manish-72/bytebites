package com.bytebites.service;

import com.bytebites.model.Order;
import com.bytebites.model.PaymentResponse;
import com.bytebites.repository.OrderRepository;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;

@Service
public class PaymentServiceImplementation implements PaymentService{
	private final OrderRepository orderRepository;

	public PaymentServiceImplementation(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}
	
	
	@Value("${stripe.api.key}")
	 private String stripeSecretKey;

	@Override
	public PaymentResponse generatePaymentLink(Long orderId) throws StripeException {
		Order order = orderRepository.findById(orderId)
				.orElseThrow(() -> new NoSuchElementException("Order not found with id: " + orderId));

		if (stripeSecretKey == null || stripeSecretKey.isBlank()) {
			throw new IllegalStateException("Missing Stripe API key. Set STRIPE_API_KEY environment variable.");
		}

	  Stripe.apiKey = stripeSecretKey;

	        SessionCreateParams params = SessionCreateParams.builder()
	                .addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
	                .setMode(SessionCreateParams.Mode.PAYMENT)
	                .setSuccessUrl("https://bytebites.vercel.app/payment/success/"+order.getId())
	                .setCancelUrl("https://bytebites.vercel.app/cancel")
	                .addLineItem(SessionCreateParams.LineItem.builder()
	                        .setQuantity(1L)
	                        .setPriceData(SessionCreateParams.LineItem.PriceData.builder()
	                                .setCurrency("usd")
	                                .setUnitAmount((long) order.getTotalAmount()*100) // Specify the order amount in cents
	                                .setProductData(SessionCreateParams.LineItem.PriceData.ProductData.builder()
	                                        .setName("pizza burger")
	                                        .build())
	                                .build())
	                        .build())
	                .build();
	        
	        Session session = Session.create(params);
	        
	        System.out.println("session _____ " + session);
	        
	        PaymentResponse res = new PaymentResponse();
	        res.setPayment_url(session.getUrl());
	        
	        return res;
	    
	}

}
