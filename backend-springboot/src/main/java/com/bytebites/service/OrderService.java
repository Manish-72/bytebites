package com.bytebites.service;

import java.util.List;

import com.stripe.exception.StripeException;
import com.bytebites.Exception.CartException;
import com.bytebites.Exception.OrderException;
import com.bytebites.Exception.RestaurantException;
import com.bytebites.Exception.UserException;
import com.bytebites.model.Order;
import com.bytebites.model.PaymentResponse;
import com.bytebites.model.User;
import com.bytebites.request.CreateOrderRequest;

public interface OrderService {
	
	 public PaymentResponse createOrder(CreateOrderRequest order, User user) throws UserException, RestaurantException, CartException, StripeException;
	 
	 public Order updateOrder(Long orderId, String orderStatus) throws OrderException;
	 
	 public void cancelOrder(Long orderId) throws OrderException;
	 
	 public List<Order> getUserOrders(Long userId) throws OrderException;
	 
	 public List<Order> getOrdersOfRestaurant(Long restaurantId,String orderStatus) throws OrderException, RestaurantException;
	 

}
