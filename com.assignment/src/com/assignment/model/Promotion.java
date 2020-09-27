package com.assignment.model;

/**
 * @author Nagaraj
 *
 */
public class Promotion {

	private String ProductName;
	private int promotionValue;
	private int quantity;

	/**
	 * @param productName
	 * @param promotionValue
	 * @param quantity
	 */
	public Promotion(String productName, int promotionValue, int quantity) {
		super();
		ProductName = productName;
		this.promotionValue = promotionValue;
		this.quantity = quantity;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return ProductName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		ProductName = productName;
	}

	/**
	 * @return the promotionValue
	 */
	public int getPromotionValue() {
		return promotionValue;
	}

	/**
	 * @param promotionValue the promotionValue to set
	 */
	public void setPromotionValue(int promotionValue) {
		this.promotionValue = promotionValue;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
