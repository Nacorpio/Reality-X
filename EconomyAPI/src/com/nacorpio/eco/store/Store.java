package com.nacorpio.eco.store;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a store.
 * <p>
 * The main purpose of a store is for it to hold commodities.<br>
 * An instance of this class has to be linked to the VisualStore.
 * @author Nacorpio
 *
 */
public class Store {

	private String name;
	private String company;
	
	//
	private List<StoreItem> range =
			new ArrayList<StoreItem>();
	
	private List<Float> investments =
			new ArrayList<Float>();
	
	private float expenditure;
	private float income;
	
	public Store(String par1, String par2) {
		name = par1;
		company = par2;
	}

	/**
	 * Returns the investments that has been made to this store.
	 * @return the investments.
	 */
	public final List<Float> getInvestments() {
		return investments;
	}
	
	/**
	 * Returns the available range of commodities that can be bought within this store.
	 * @return the range.
	 */
	public final List<StoreItem> getRange() {
		return range;
	}
	
	/**
	 * Returns the amount of money that was put into this store when it was inaugurated.
	 * @return the start investment.
	 */
	public final float getStartInvestment() {
		return (investments.size() >= 1 ? investments.get(0) : -1);
	}
	
	/**
	 * Returns the amount of money that has been put into this store in total.
	 * @return the total investment.
	 */
	public final float getTotalInvestment() {
		float total = 0;
		for (Float var: investments) {
			total += var;
		}
		return total;
	}
	
	/**
	 * Returns the total cost of the whole range of commodities within this store.
	 * @return the range cost.
	 */
	public final float getRangeCost() {
		float total = 0;
		for (StoreItem var: range) {
			total += var.getCommodity().getTotalPrice();
		}
		return total;
	}
	
	/**
	 * Returns the amount money that has been coming in from sales within this store.
	 * @return the income.
	 */
	public final float getIncome() {
		return income;
	}
	
	/**
	 * Returns the current worth of this store.
	 * @return the worth.
	 */
	public final float getWorth() {
		return -1;
	}
	
	/**
	 * Returns the expenditure of this store.<br>
	 * This includes objects that have been bought, as well as new items.
	 * @return the expenditure.
	 */
	public final float getExpenditure() {
		return expenditure;
	}
	
	/**
	 * Returns the total amount of profit that has been made from the sales of this store.
	 * @return the profit.
	 */
	public final float getProfit() {
		return income - expenditure;
	}
	
}
