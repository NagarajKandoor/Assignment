package com.assignment;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.assignment.model.CartItem;

/**
 * @author Nagaraj
 *
 */
class CartItemTest {
	private CartItem cartitem;

	@BeforeEach
	void setUp() throws Exception {
		cartitem = new CartItem(1, 'A');
	}

	@Test
	final void testGetCartItemsPostive() {
		assertEquals(1, cartitem.getQuntity());
		assertEquals('A', cartitem.getProductName().toString());
	}

	@Test
	final void testGetCartItemsNegative() {
		assertNotEquals(2, cartitem.getQuntity());
	}

	@AfterEach
	void clear() {
		cartitem = null;
	}
}
