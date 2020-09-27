package com.assignment;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.assignment.model.Cart;
import com.assignment.model.CartItem;

/**
 * @author Nagaraj
 *
 */
class CartTest {

	/**
	 * @throws java.lang.Exception
	 */
	private CartItem i1;
	private CartItem i2;
	private CartItem i3;
	private Cart cart;
	private List<CartItem> items;

	@BeforeEach
	void setUp() throws Exception {
		i1 = new CartItem(1, 'A');
		i2 = new CartItem(1, 'B');
		i3 = new CartItem(1, 'C');
		items = new ArrayList<CartItem>();
		items.add(i1);
		items.add(i2);
		items.add(i3);
		cart=  new Cart();
		cart.setCart(items);
		
	}

	@Test
	final void testGetCartItemsPostive() {
		assertEquals(3, cart.getCart().size());
		assertEquals('A', cart.getCart().get(0));
	}

	@Test
	final void testGetCartItemsNegative() {
		assertNotEquals(2, cart.getCart().size());
	}

	@AfterEach
	void clear() {
		cart = null;
	}

}
