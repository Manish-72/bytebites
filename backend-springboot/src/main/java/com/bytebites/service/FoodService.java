package com.bytebites.service;

import java.util.List;

import com.bytebites.Exception.FoodException;
import com.bytebites.Exception.RestaurantException;
import com.bytebites.model.Category;
import com.bytebites.model.Food;
import com.bytebites.model.Restaurant;
import com.bytebites.request.CreateFoodRequest;

public interface FoodService {

	public Food createFood(CreateFoodRequest req,Category category,
						   Restaurant restaurant) throws FoodException, RestaurantException;

	void deleteFood(Long foodId) throws FoodException;
	
	public List<Food> getRestaurantsFood(Long restaurantId,
			boolean isVegetarian, boolean isNonveg, boolean isSeasonal,String foodCategory) throws FoodException;
	
	public List<Food> searchFood(String keyword);
	
	public Food findFoodById(Long foodId) throws FoodException;

	public Food updateAvailibilityStatus(Long foodId) throws FoodException;
}
