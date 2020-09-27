package com.assignment.model;

/**
 * @author Nagaraj
 *
 */
public class CartItem {

	private int quntity;
	private Character productName;

	/**
	 * @param quntity
	 * @param productName
	 */
	public CartItem(int quntity, Character productName) {
		super();
		this.quntity = quntity;
		this.productName = productName;
	}

	/**
	 * @return the quntity
	 */
	public int getQuntity() {
		return quntity;
	}

	/**
	 * @return the productName
	 */
	public Character getProductName() {
		return productName;
	}

}
