package com.assignment;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Nagaraj
 *
 */
class CartTest {
	private Cart cart;

	@BeforeEach
	void setUp() throws Exception {
		cart = new Cart();
		List<Character> cartItems = new ArrayList<Character>();
		cartItems.add('A');
		cartItems.add('B');
		cartItems.add('C');
		cart.setCartItems(cartItems);
	}

	@Test
	final void testGetCartItemsPostive() {
		assertEquals(3, cart.getCartItems().size());
		assertEquals('A', cart.getCartItems().get(0));
	}

	@Test
	final void testGetCartItemsNegative() {
		assertNotEquals(2, cart.getCartItems().size());
	}

	@AfterEach
	void clear() {
		cart = null;
	}
}
