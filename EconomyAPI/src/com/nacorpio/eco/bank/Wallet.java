package com.nacorpio.eco.bank;

import java.util.ArrayList;
import java.util.List;

import com.nacorpio.eco.IWalletItem;
import com.nacorpio.eco.cash.Bill;
import com.nacorpio.eco.cash.CashUtil;
import com.nacorpio.eco.cash.Coin;
import com.nacorpio.eco.enumeration.CASH_BILL;
import com.nacorpio.eco.enumeration.CASH_COIN;

public class Wallet { 
	
	
	
	protected List<Bill> billContent =
			new ArrayList<Bill>();
	
	protected List<Coin> coinContent =
			new ArrayList<Coin>();
	
	protected List<Card> cardContent =
			new ArrayList<Card>();
	
	protected int billSpaceSize;
	protected int coinSpaceSize;
	protected int cardSpaceSize;
	
	/**
	 * Creates a new instance of a Wallet.
	 * @param par1 the size of the bill department (in bills).
	 * @param par2 the size of the coin department (in coins).
	 */
	public Wallet(int par1, int par2) {
		billSpaceSize = par1;
		coinSpaceSize = par2;
	}
	
	/**
	 * Returns the required bills and coins to cover the specified sum of money.
	 * @param par1 the amount of money to cover.
	 * @return a list of the IWalletItem within the Wallet that are needed to cover the costs. 
	 */
	public final List<IWalletItem> getContentFor(float par1) {	
		if (hasRequired(par1)) {
			
			List<CASH_BILL> bills = new ArrayList<CASH_BILL>();
			List<CASH_COIN> coins = new ArrayList<CASH_COIN>();
			
			float target = par1;
			
			while (target > 0) {
				
				if (target >= 1) {
					
					CASH_BILL bill = CASH_BILL.closest(target);
					bills.add(bill);
					
					target -= bill.value;
					
				} else if (target <= 1) {
					
					CASH_COIN coin = CASH_COIN.closest(target);
					coins.add(coin);
					
					target -= coin.value;
					
				}
				
			}
			
			List<IWalletItem> items = CashUtil.enumToItems(bills, coins);
			
			if (CashUtil.calculateCost(items) == par1) {
				return items;
			}
			return null;
			
			
		}
		return null;
	}
	
	/**
	 * Add content to this wallet.
	 * <p>
	 * Depending on the item, it will be added to a separate department in this Wallet.<br>
	 * The size of the different departments are defined when initializing the instance.
	 * @param par1 the item.
	 */
	public final void addContent(IWalletItem par1) {
		if (par1 instanceof Bill) {
			if (billContent.size() + 1 <= billSpaceSize) {
				billContent.add((Bill) par1);
		 	} else {
				// The limit for bills was exceeded.
			}
		} else if (par1 instanceof Coin) {
			if (coinContent.size() + 1 <= coinSpaceSize) {
				coinContent.add((Coin) par1);
			} else {
				// The limit for coins was exceeded.
			}
		} else if (par1 instanceof Card) {
			if (cardContent.size() + 1 <= cardSpaceSize) {
				cardContent.add((Card) par1);
			} else {
				// The limit for cards was exceeded.
			}
		}
	}
	
	/**
	 * Returns whether this Wallet has more or equal to the specified amount.
	 * @param par1 the amount to check.
	 * @return true/false.
	 */
	public final boolean hasRequired(float par1) {
		return getTotalValue() >= par1;
	}
	
	/**
	 * Returns the coin at the specified slot in the coin department.
	 * @param par1 the index of the slot to retrieve.
	 * @return the coin.
	 */
	public final Coin getCoinSlot(int par1) {
		return coinContent.get(par1);
	}
	
	/**
	 * Returns the bill at the specified slot in the bill department.
	 * @param par1 the index of the slot to retrieve.
	 * @return the bill.
	 */
	public final Bill getBillSlot(int par1) {
		return billContent.get(par1);
	}
	
	/**
	 * Returns the total value of all the cash together in this Wallet.
	 * @return the total value.
	 */
	public final float getTotalValue() {
		return getCoinValue() + getBillValue();
	}
	
	/**
	 * Returns the value of all the coins within this Wallet.
	 * @return the coin value.
	 */
	public final float getCoinValue() {
		float value = 0;
		for (Coin par: coinContent) {
			value += par.getValue();
		}
		return value;
	}
	
	/**
	 * Returns the value of all the bills within this wallet.
	 * @return the bill value.
	 */
	public final float getBillValue() {
		float value = 0;
		for (Bill par: billContent) {
			value += par.getValue();
		}
		return value;
	}
	
}
