package com.nacorpio.eco.bank;

import java.util.ArrayList;
import java.util.List;

import com.nacorpio.eco.IWalletItem;
import com.nacorpio.eco.cash.Bill;
import com.nacorpio.eco.cash.BillFifty;
import com.nacorpio.eco.cash.BillFive;
import com.nacorpio.eco.cash.BillHundred;
import com.nacorpio.eco.cash.BillOne;
import com.nacorpio.eco.cash.BillTen;
import com.nacorpio.eco.cash.BillTwenty;
import com.nacorpio.eco.cash.BillTwo;
import com.nacorpio.eco.cash.Coin;
import com.nacorpio.eco.cash.Coin10Cent;
import com.nacorpio.eco.cash.Coin1Cent;
import com.nacorpio.eco.cash.Coin1Dollar;
import com.nacorpio.eco.cash.Coin25Cent;
import com.nacorpio.eco.cash.Coin50Cent;
import com.nacorpio.eco.cash.Coin5Cent;

public class Wallet { 
	
	public static enum CASH_BILL {
		
		BILL_ONE(1, BillOne.class),
		BILL_FIVE(5, BillFive.class),
		BILL_TEN(10, BillTen.class),
		BILL_TWENTY(20, BillTwenty.class),
		BILL_FIFTY(50, BillFifty.class),
		BILL_HUNDRED(100, BillHundred.class);
		
		public float value;
		Class<? extends IWalletItem> clazz;
		
		CASH_BILL(float par1, Class<? extends IWalletItem> par2) {
			value = par1;
		}
		
		public static final CASH_BILL closest(float par1) {
			
			List<Float> test = new ArrayList<Float>();
			
			for (CASH_BILL var: values()) {
				if (par1 >= var.value) {
					test.add(par1 - var.value);
				}
			}
			
			float least = 0f;
			int cindex = 0;
			
			for (Float var: test) {
				if (var < least)
					least = var;
					cindex++;
			}
			
			return values()[cindex - 1];
			
		}
		
		public static final CASH_BILL byValue(float par1) {
			for (CASH_BILL var: values()) {
				if (var.value == par1)
					return var;
			}
			return null;
		}
		
	}
	
	public static enum CASH_COIN {
		
		COIN_1C(0.01f, Coin1Cent.class),
		COIN_5C(0.05f, Coin5Cent.class),
		COIN_10C(0.1f, Coin10Cent.class),
		COIN_25C(0.25f, Coin25Cent.class),
		COIN_50C(0.5f, Coin50Cent.class),
		COIN_1(1, Coin1Dollar.class);
		
		public float value;
		Class<? extends IWalletItem> clazz;
		
		CASH_COIN(float par1, Class<? extends IWalletItem> par2) {
			value = par1;
		}
		
		public static final CASH_COIN closest(float par1) {
			
			List<Float> test = new ArrayList<Float>();
			
			for (CASH_COIN var: values()) {
				if (par1 >= var.value) {
					test.add(par1 - var.value);
				}
			}
			
			float least = 0f;
			int cindex = 0;
			
			for (Float var: test) {
				if (var < least)
					least = var;
					cindex++;
			}
			
			return values()[cindex - 1];
			
		}
		
		public static final CASH_COIN byValue(float par1) {
			for (CASH_COIN var: values()) {
				if (var.value == par1)
					return var;
			}
			return null;
		}
		
	}
	
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
	 * Add content to this wallet.
	 * <p>
	 * Depending on the item, it will be added to a seperate department in this Wallet.<br>
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
