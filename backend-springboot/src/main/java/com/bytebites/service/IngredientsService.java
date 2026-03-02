package com.bytebites.service;

import java.util.List;

import com.bytebites.Exception.FoodException;
import com.bytebites.Exception.RestaurantException;
import com.bytebites.model.IngredientCategory;
import com.bytebites.model.IngredientsItem;
import com.bytebites.model.Food;
import com.bytebites.repository.IngredientsCategoryRepository;

public interface IngredientsService {
	
	public IngredientCategory createIngredientsCategory(
			String name,Long restaurantId) throws RestaurantException;

	public IngredientCategory findIngredientsCategoryById(Long id) throws Exception;

	public List<IngredientCategory> findIngredientsCategoryByRestaurantId(Long id) throws Exception;
	
	public List<IngredientsItem> findRestaurantsIngredients(
			Long restaurantId);

	
	public IngredientsItem createIngredientsItem(Long restaurantId, 
			String ingredientName,Long ingredientCategoryId) throws Exception;

	public IngredientsItem updateStoke(Long id) throws Exception;
	
}
