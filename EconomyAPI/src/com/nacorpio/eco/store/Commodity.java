package com.nacorpio.eco.store;

public class Commodity {

	private String name;	

	private float price;
	private float taxPercentage;
	
	public Commodity(String par1, float par2, float par3, String par4) {
		name = par1;
		price = par2;
		taxPercentage = par3;
	}

	/**
	 * Returns the name of this item.
	 * @return the name.
	 */
	public final String getName() {
		return name;
	}

	/**
	 * Returns the total price of this item.
	 * @return the total price.
	 */
	public final float getTotalPrice() {
		return price + getTaxes();
	}
	
	/**
	 * Returns the taxes of this item.
	 * @return the taxes.
	 */
	public final float getTaxes() {
		return price * (taxPercentage / 100);
	}
	
}
