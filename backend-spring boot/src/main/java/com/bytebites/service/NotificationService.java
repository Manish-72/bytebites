package com.bytebites.service;

import java.util.List;

import com.bytebites.model.Notification;
import com.bytebites.model.Order;
import com.bytebites.model.Restaurant;
import com.bytebites.model.User;

public interface NotificationService {
	
	public Notification sendOrderStatusNotification(Order order);
	public void sendRestaurantNotification(Restaurant restaurant, String message);
	public void sendPromotionalNotification(User user, String message);
	
	public List<Notification> findUsersNotification(Long userId);

}
