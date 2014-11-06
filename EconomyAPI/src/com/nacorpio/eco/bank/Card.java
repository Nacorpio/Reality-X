package com.nacorpio.eco.bank;

import com.nacorpio.eco.IWalletItem;

public abstract class Card implements IWalletItem {

	private String number;
	private int securityCode;
	private int expiryMonth, expiryYear;
	
	protected int passCode;
	
	private Account account;
	
	//
	
	/**
	 * Creates a new instance of a Card.
	 * @param par1 the account of the Card.
	 */
	public Card(Account par1) {
		this.account = par1;
	}
	
	/**
	 * Withdraw money from this Card and deposit it into the specified Wallet.
	 * @param par1 the passcode of this Card.
	 * @param par2 the amount of money to withdraw.
	 * @param par3 the recipient.
	 */
	public abstract void withdraw(int par1, float par2, Object par3);
	
	/**
	 * Deposit money to this Card from the specified cash holder.
	 * @param par1 the passcode of this Card.
	 * @param par2 the amount of money to deposit.
	 * @param par3 the cash holder.
	 */
	public abstract void deposit(int par1, float par2, Object par3);
	
	/**
	 * Returns the unique number of this card.
	 * @return the number.
	 */
	public final String getNumber() {
		return number;
	}
	
	/**
	 * Returns the security code found on the back of the card.<br>
	 * The length of the code depends on the type of card.
	 * @return the security code.
	 */
	public final int getSecurityCode() {
		return securityCode;
	}
	
	/**
	 * Returns the month of which this card expires.<br>
	 * There will be no functionality once the card has expired.
	 * @return the expiry month.
	 */
	public final int getExpiryMonth() {
		return expiryMonth;
	}

	/**
	 * Returns the year of which this card expires.<br>
	 * There will be no functionality once the card has expired.
	 * @return the expiry year.
	 */
	public final int getExpiryYear() {
		return expiryYear;
	}
	
	/**
	 * Returns the bank account of this card.<br>
	 * This is where the money is stored virtually using credits.
	 * @return the account.
	 */
	public final Account getAccount() {
		return account;
	}
	
	@Override
	public final float getValue() {
		return -1;
	}

}
