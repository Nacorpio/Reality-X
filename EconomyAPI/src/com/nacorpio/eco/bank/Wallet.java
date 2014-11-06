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
		
		float value;
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
		
		float value;
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
	
	
	
	public static final List<IWalletItem> byCash(float par1) throws InstantiationException, IllegalAccessException {
		
		/**
		 * Defining the lists that will be holding the necessary values.
		 */
		List<IWalletItem> finalres = new ArrayList<IWalletItem>();
		List<Float> result = new ArrayList<Float>();
		
		float var1 = par1;
			
		/*
		 * 
		 */
		while (var1 > 0) {
			
			/* 
			 * Check if we need bills or coins.
			 * If the value is greater or equal to the value of 1, it's always a bill or a $1 coin.
			 * Though, if the value is less than the value of 1, it's always a coin (cents).
			 */
			
			/*
			 * In this case, we have a bill.
			 */
			if (par1 >= 1) {
				
				/*
				 * We find the closest bill to the value we're trying to calculate.
				 * If we have a value of $105 for example, we get the $100 bill.
				 * Another case, if we have $45, we get the $20 bill.
				 */
				CASH_BILL bill = CASH_BILL.closest(par1);
				
				/*
				 * We add the value of the bill which is closest to our value to a list.
				 * This is the list of all bill values that we need to reach the final value.
				 */
				result.add(bill.value);
				
				/**
				 * The var1 variable is used for calculating how much is left everytime.
				 * This variable has a initial value of the value that we input.
				 */
				var1 -= bill.value;
				
			/*
			 * In this case we have a coin.
			 */
			} else if (par1 < 1) {
				
				/*
				 * Just like we did before, we find the closest matching coin.
				 */
				CASH_COIN coin = CASH_COIN.closest(par1);
				
				/**
				 * Like we did before, we add the matching value to our list of floats.
				 */
				result.add(coin.value);
				
				/**
				 * And then we subtract the value from our init-valued variable.
				 */
				var1 -= coin.value;
				
			}
		}
		
		/**
		 * This is a stupid thing; I just make a new variable out of another one.
		 * I'm sorry - I was just lazy.
		 */
		float left = var1;
		
		/*
		 * I don't know if this is a good idea or not; I'm trying to add the remaining cash into the list of floats.
		 * Correct me if this isn't a good way of doing it - it looks like I'm getting the wrong outcome from doing it.
		 */
		result.add(left);
		
		/*
		 * Now we have to go through every value within the float list.
		 * We then check the value, and match it with a class, and then create a new instance of that class.
		 */
		for (Float var: result) {
			
			/*
			 * As we did before, we now check if it's a bill or a coin by checking the value.
			 */
			if (var >= 1) {
				
				// bill
				
				/*
				 * We now look if there's a bill that represents the current value in the float list.
				 */
				CASH_BILL bill = CASH_BILL.byValue(var);
				
				/*
				 *  This is just hard-coded; there might be better ways of doing this.
				 *  I'm just checking what type of bill we get, and then add it to the finalres list.
				 */

				if (bill == CASH_BILL.BILL_ONE) {
					finalres.add(new BillOne());
				} else if (bill == CASH_BILL.BILL_FIVE) {
					finalres.add(new BillFive());
				} else if (bill == CASH_BILL.BILL_TEN) {
					finalres.add(new BillTen());
				} else if (bill == CASH_BILL.BILL_TWENTY) {
					finalres.add(new BillTwenty());
				} else if (bill == CASH_BILL.BILL_FIFTY) {
					finalres.add(new BillFifty());
				} else if (bill == CASH_BILL.BILL_HUNDRED) {
					finalres.add(new BillHundred());
				}
				
			} else {
				
				/**
				 * The same thing happens below, but it's about coins instead.
				 */
				
				// coin
				CASH_COIN coin = CASH_COIN.byValue(var);
				
				if (coin == CASH_COIN.COIN_1C) {
					finalres.add(new Coin1Cent());
				} else if (coin == CASH_COIN.COIN_5C) {
					finalres.add(new Coin5Cent());
				} else if (coin == CASH_COIN.COIN_10C) {
					finalres.add(new Coin10Cent());
				} else if (coin == CASH_COIN.COIN_25C) {
					finalres.add(new Coin25Cent());
				} else if (coin == CASH_COIN.COIN_50C) {
					finalres.add(new Coin50Cent());
				} else if (coin == CASH_COIN.COIN_1) {
					finalres.add(new Coin1Dollar());
				}
				
			}
		}
		
		/*
		 * Now the list is filled with the coins and bills, and is ready to be returned for usage.
		 */
		return finalres;
		
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
