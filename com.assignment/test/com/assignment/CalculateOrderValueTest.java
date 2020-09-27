package com.assignment;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.assignment.exceptions.PropertyException;
import com.assignment.model.Cart;
import com.assignment.model.CartItem;
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
	private ProcessActivePromotions processPro;
	private Inventory inventory;
	private CartItem i1;
	private CartItem i2;
	private CartItem i3;
	private Cart cart;
	private List<CartItem> items;

	@BeforeEach
	void setUp() throws Exception {
		items = new ArrayList<CartItem>();
		cart = new Cart();
		ProcessProperties properties = new ProcessProperties();
		processPro = new ProcessActivePromotions(properties);
		inventory = new Inventory(properties);
	}

	@Test
	final void test() throws PropertyException, IOException {
		i1 = new CartItem(1, 'A');
		i2 = new CartItem(1, 'B');
		i3 = new CartItem(1, 'C');
		items.add(i1);
		items.add(i2);
		items.add(i3);
		cart.setCart(items);
		calculateOrderValue = new CalculateOrderValue(cart, processPro, inventory);
		assertEquals(100, calculateOrderValue.getOrderValue());
	}
	@Test
	final void test2() throws PropertyException, IOException {
		i1 = new CartItem(5, 'A');
		i2 = new CartItem(5, 'B');
		i3 = new CartItem(1, 'C');
		items.add(i1);
		items.add(i2);
		items.add(i3);
		cart = new Cart();
		cart.setCart(items);
		calculateOrderValue = new CalculateOrderValue(cart, processPro, inventory);
		assertEquals(370, calculateOrderValue.getOrderValue());
	}

}
