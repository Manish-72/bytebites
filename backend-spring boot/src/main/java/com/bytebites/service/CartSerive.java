package com.bytebites.service;

import com.bytebites.Exception.CartException;
import com.bytebites.Exception.CartItemException;
import com.bytebites.Exception.FoodException;
import com.bytebites.Exception.UserException;
import com.bytebites.model.Cart;
import com.bytebites.model.CartItem;
import com.bytebites.model.Food;
import com.bytebites.model.User;
import com.bytebites.request.AddCartItemRequest;
import com.bytebites.request.UpdateCartItemRequest;

public interface CartSerive {

	public CartItem addItemToCart(AddCartItemRequest req, String jwt) throws UserException, FoodException, CartException, CartItemException;

	public CartItem updateCartItemQuantity(Long cartItemId,int quantity) throws CartItemException;

	public Cart removeItemFromCart(Long cartItemId, String jwt) throws UserException, CartException, CartItemException;

	public Long calculateCartTotals(Cart cart) throws UserException;
	
	public Cart findCartById(Long id) throws CartException;
	
	public Cart findCartByUserId(Long userId) throws CartException, UserException;
	
	public Cart clearCart(Long userId) throws CartException, UserException;
	

	

}
