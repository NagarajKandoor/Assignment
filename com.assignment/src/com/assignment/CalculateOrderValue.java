package com.assignment;

import com.assignment.model.Cart;

/**
 * @author Nagaraj
 *
 */
public class CalculateOrderValue {
	private Cart cart;
	private ProcessActivePromotions activePromotions;
	private Inventory inventory;

	/**
	 * @param cart
	 * @param activePromotions
	 */
	public CalculateOrderValue(Cart cart, ProcessActivePromotions activePromotions, Inventory inventory) {
		this.cart = cart;
		this.activePromotions = activePromotions;
		this.inventory = inventory;
	}
	
	public int getOrderValue() {
		
		return 0;
	}
}
