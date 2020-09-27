package com.assignment;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

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
		if (isContainsBoth(items)) {
			for (CartItem ct : items) {
				if (!ct.getProductName().toString().contains("C") && !ct.getProductName().toString().contains("D")) {
					orderValue += calculate(ct.getQuntity(),
							Integer.valueOf(stockPrice.get(ct.getProductName().toString())), activePromotion,
							ct.getProductName().toString());
				}
			}
			orderValue += getPromotionValue(activePromotion);

		} else {
			for (CartItem ct : items) {
				orderValue += calculate(ct.getQuntity(),
						Integer.valueOf(stockPrice.get(ct.getProductName().toString())), activePromotion,
						ct.getProductName().toString());
			}
		}
		return orderValue;
	}

	public int getPromotionValue(List<Promotion> activePromotion) {
		for (Promotion ct : activePromotion) {
			if (ct.getProductName().toString().contains("C")) {
				return ct.getPromotionValue();
			}
		}
		return 0;

	}

	public static boolean isContainsBoth(List<CartItem> items) {
		boolean isConatinsC = false;
		boolean isConatinsD = false;
		for (CartItem ct : items) {
			if (ct.getProductName().toString().contains("C")) {
				isConatinsC = true;
			} else if (ct.getProductName().toString().contains("D")) {
				isConatinsD = true;
			}
		}
		return isConatinsC == isConatinsD;
	}

	public static int calculate(int quantity, int price, List<Promotion> activePromotion, String pdName) {
		return applyPromotion(activePromotion, quantity, price, pdName);
	}

	public static int applyPromotion(List<Promotion> activePromotion, int quantity, int price, String pdName) {
		int orderValue = 0;
		for (Promotion pm : activePromotion) {
			if (pm.getProductName().equalsIgnoreCase(pdName)) {
				if (quantity == 1) {
					return price;
				}
				int quotient = quantity / pm.getQuantity();
				for (int i = 0; i < quotient; i++) {
					orderValue += pm.getPromotionValue();
				}
				orderValue += ((quantity - quotient * pm.getQuantity()) * price);
				if (orderValue < price) {
					return price;
				}
			} else {
				if (quantity == 1) {
					return price;
				}
				if (pm.getProductName().contains(pdName)) {
					int quotient = quantity / pm.getQuantity();
					for (int i = 0; i < quotient; i++) {
						orderValue += pm.getPromotionValue();
					}
					orderValue += ((quantity - quotient * pm.getQuantity()) * price);
				}
			}
		}
		return orderValue;
	}
}
