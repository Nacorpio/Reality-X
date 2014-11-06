package com.nacorpio.eco.cost;

/**
 * Implemented by classes of objects that are buyable.
 * @author Nacorpio
 *
 */
public interface IEconomical {
	
	/**
	 * Returns the name of this econimical item.
	 * @return the name.
	 */
	String getName();
	
	/**
	 * Returns the percentage of tax from the original price.
	 * @return the tax percentage.
	 */
	float getTaxPercentage();
	
	/**
	 * Returns the price without taxes.
	 * @return the price.
	 */
	float getPrice();
	
}
