package com.nacorpio.eco.bank;

import com.nacorpio.eco.IWalletItem;
import com.nacorpio.eco.bank.card.ICashHolder;

public abstract class Card implements IWalletItem, ICashHolder {

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
	 * Withdraw money from this Card and deposit it into the specified cash holder.
	 * @param par1 the passcode of this Card.
	 * @param par2 the amount of money to withdraw.
	 * @param par3 the recipient.
	 */
	public abstract boolean withdraw(int par1, float par2, ICashHolder par3);
	
	/**
	 * Deposit money to this Card from the specified cash holder.
	 * @param par1 the passcode of this Card.
	 * @param par2 the amount of money to deposit.
	 * @param par3 the cash holder.
	 */
	public abstract boolean deposit(int par1, float par2, ICashHolder par3);
	
	/**
	 * An event which occurs when a deposit is being authorized from this {@code Card}.
	 * @param par1 the cash holder of which the virtual credit is being sent from.
	 * @param par2 the amount of virtual credit which is being deposited.
	 */
	public abstract void onDepositAuthEvent(ICashHolder par1, float par2);
	
	/**
	 * An event which occurs when a deposit has been completed between this Card and a cash holder.
	 * @param par1 the cash holder of which the virtual credit was sent from.
	 * @param par2 the amount of virtual credit which was deposited.
	 */
	public abstract void onDepositCompleteEvent(ICashHolder par1, float par2);
	
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
