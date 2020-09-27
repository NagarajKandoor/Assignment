package com.assignment.model;

import java.util.List;

/**
 * @author Nagaraj
 *
 */
public class Cart {

	private List<CartItem> cart;

	/**
	 * @return the cart
	 */
	public List<CartItem> getCart() {
		return cart;
	}

	/**
	 * @param cart the cart to set
	 */
	public void setCart(List<CartItem> cart) {
		this.cart = cart;
	}

}
