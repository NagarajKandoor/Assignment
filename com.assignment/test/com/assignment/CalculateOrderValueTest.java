package com.assignment;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.assignment.model.Cart;
import com.assignment.processproperty.ProcessProperties;

/**
 * @author Nagaraj
 *
 */
class CalculateOrderValueTest {

	/**
	 * @throws java.lang.Exception
	 */
	private CalculateOrderValue calculateOrderValue;
	private Cart cart;
	private ProcessActivePromotions processPro;
	private Inventory inventory;

	@BeforeEach
	void setUp() throws Exception {
		cart = new Cart();
		List<Character> cartItems = new ArrayList<Character>();
		cartItems.add('A');
		cartItems.add('B');
		cartItems.add('C');
		cart.setCartItems(cartItems);

		ProcessProperties properties = new ProcessProperties();
		processPro = new ProcessActivePromotions(properties);
		inventory = new Inventory(properties);
		calculateOrderValue = new CalculateOrderValue(cart, processPro, inventory);
	}

	@Test
	final void test() {
		assertEquals(100,calculateOrderValue.getOrderValue());
	}

}
