package com.assignment;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.assignment.exceptions.PropertyException;
import com.assignment.model.Cart;
import com.assignment.model.CartItem;
import com.assignment.model.Promotion;

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

	public int getOrderValue() throws PropertyException, IOException {
		int orderValue = 0;
		List<CartItem> items = cart.getCart();
		HashMap<String, String> stockPrice = inventory.getInventory("ProductNameValue.properties");
		List<Promotion> activePromotion = activePromotions.getActivePromotions("ActivePromotions.properties");
		for (CartItem ct : items) {
			orderValue += calculate(ct.getQuntity(), Integer.valueOf(stockPrice.get(ct.getProductName().toString())));
		}

		return orderValue;
	}

	public static int calculate(int quantity, int price) {
		return quantity * price;

	}
}
