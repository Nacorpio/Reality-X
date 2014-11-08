package com.nacorpio.eco.bank.card;

public interface ICashHolder {

	/**
	 * Returns the balance of credit within this {@code ICashHolder}.
	 * @return the balance.
	 */
	float getBalance();
	
	/**
	 * Adds the specified amount of credit to this {@code ICashHolder}.
	 * @param par1 the amount of credits.
	 */
	void add(float par1);
	
	/**
	 * Removes the specified amount of credit from this {@code ICashHolder}.
	 * @param par1 the amount of credits.
	 */
	void remove(float par1);
	
	/**
	 * Transfers the specified amount of credits to the specified ICashHolder.
	 * @param par1 the recipient.
	 * @param par2 the amount of credits.
	 */
	void transfer(ICashHolder par1, float par2);
	
	/**
	 * Returns whether this ICashHolder has sufficient credits for the specified change.
	 * @param par1 the change.
	 * <br>
	 * <div>
	 * - If the change is negative, there will be a subtraction check;<br>
	 * - if the change is positive, there will be an addition check.
	 * </div>
	 * @return true/false.
	 */
	boolean hasSufficientCapacity(float par1);
	
	/**
	 * Returns whether this ICashHolder has sufficient credits to commit the specified change.
	 * @param par1 the change.
	 * @return true/false.
	 */
	boolean hasSufficientCredits(float par1);
	
	/**
	 * Returns the limit for how much credit can be stored in this ICashHolder.
	 * @return the limit.
	 */
	float getCreditLimit();
	
}
