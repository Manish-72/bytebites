package com.bytebites.request;

import java.util.List;

import com.bytebites.model.Food;

import lombok.Data;

@Data
public class AddCartItemRequest {
	
	private Long menuItemId;
	private int quantity;
	private List<String> ingredients;

}
