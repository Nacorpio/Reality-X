package com.nacorpio.eco.cash;

import java.util.ArrayList;
import java.util.List;

import com.nacorpio.eco.IWalletItem;
import com.nacorpio.eco.enumeration.CASH_BILL;
import com.nacorpio.eco.enumeration.CASH_COIN;

public class CashUtil {
	
	public static final List<IWalletItem> calculateChange(float par1, float par2) {
		if (par2 >= par1) {		
			float change = par2 - par1;
			return calculateItems(change);	
		}
		return null;
	}
	 
	public static final float calculateCost(List<IWalletItem> par1) {
		
		float result = 0;
		
		for (IWalletItem var: par1) {
			result += var.getValue();
		}
		
		return result;
		
	}
	
	public static final List<IWalletItem> calculateItems(float par1) {
		
		List<CASH_BILL> bills = new ArrayList<CASH_BILL>();
		List<CASH_COIN> coins = new ArrayList<CASH_COIN>();
		
		float left = par1;
		
		while (left > 0) {
			
			if (left >= 1) {
				
				CASH_BILL bill = CASH_BILL.closest(left);
				bills.add(bill);
				
				left -= bill.value;
				
			} else if (left <= 1) {
				
				CASH_COIN coin = CASH_COIN.closest(left);
				coins.add(coin);
				
				left -= coin.value;
				
			}
			
		}
		
		return enumToItems(bills, coins);
		
	}
	
	public static final List<IWalletItem> calculateItemsIn(float par1, List<IWalletItem> par2) {
		
		List<Bill> bills = new ArrayList<Bill>();
		List<Coin> coins = new ArrayList<Coin>();
		
		for (IWalletItem var: par2) {
			if (var instanceof Bill) {
				bills.add((Bill) var);
			} else if (var instanceof Coin) {
				coins.add((Coin) var);
			}
		}
		
		List<CASH_BILL> result_bills = new ArrayList<CASH_BILL>();
		List<CASH_COIN> result_coins = new ArrayList<CASH_COIN>();
		
		List<CASH_BILL> e_bills = billsToEnum(bills);
		List<CASH_COIN> e_coins = coinsToEnum(coins);
		
		float left = par1;
		
		while (left > 0) {
			
			if (left >= 1) {
				
				CASH_BILL bill = e_bills.get(greatestBillValue(e_bills));
				result_bills.add(bill);
				
				left -= bill.value;
				
			} else if (left <= 1) {
				
				CASH_COIN coin = e_coins.get(greatestCoinValue(e_coins));
				result_coins.add(coin);
				
				left -= coin.value;
				
			}
			
		}
		
		return enumToItems(result_bills, result_coins);
		
	}
	
	public static final List<CASH_BILL> billsToEnum(List<Bill> par1) {
		
		List<CASH_BILL> result = new ArrayList<CASH_BILL>();
		
		for (Bill var: par1) {
			switch ((int) var.getValue()) {
			case 1:
				result.add(CASH_BILL.BILL_ONE);
				break;
			case 5:
				result.add(CASH_BILL.BILL_FIVE);
				break;
			case 10:
				result.add(CASH_BILL.BILL_TEN);
				break;
			case 20:
				result.add(CASH_BILL.BILL_TWENTY);
				break;
			case 50:
				result.add(CASH_BILL.BILL_FIFTY);
				break;
			case 100:
				result.add(CASH_BILL.BILL_HUNDRED);
				break;
			}
		}
		
		return result;
		
	}
	
	public static final List<CASH_COIN> coinsToEnum(List<Coin> par1) {
		
		List<CASH_COIN> result = new ArrayList<CASH_COIN>();
		
		for (Coin var: par1) {
			switch ((int) var.getValue() * 100) {
			case 1:
				result.add(CASH_COIN.COIN_1);
				break;
			case 5:
				result.add(CASH_COIN.COIN_5C);
				break;
			case 10:
				result.add(CASH_COIN.COIN_10C);
				break;
			case 25:
				result.add(CASH_COIN.COIN_25C);
				break;
			case 50:
				result.add(CASH_COIN.COIN_50C);
				break;
			case 100:
				result.add(CASH_COIN.COIN_1);
				break;
			}
		}
		
		return result;
		
	}
	
	public static final List<IWalletItem> enumToItems(List<CASH_BILL> par1, List<CASH_COIN> par2) {
		
		List<IWalletItem> result = new ArrayList<IWalletItem>();
		
		for (CASH_BILL var: par1) {
			switch ((int) var.value) {
			case 1:
				result.add(new BillOne());
				break;
			case 2:
				result.add(new BillTwo());
				break;
			case 5:
				result.add(new BillFive());
				break;
			case 10:
				result.add(new BillTen());
				break;
			case 20:
				result.add(new BillTwenty());
				break;
			case 50:
				result.add(new BillFifty());
				break;
			case 100:
				result.add(new BillHundred());
				break;
			default:
				return null;
			}
		}
		
		for (CASH_COIN var: par2) {
			switch ((int) (var.value * 100)) {
			case 1:
				result.add(new Coin1Cent());
				break;
			case 10:
				result.add(new Coin10Cent());
				break;
			case 25:
				result.add(new Coin25Cent());
				break;
			case 50:
				result.add(new Coin50Cent());
				break;
			case 100:
				result.add(new Coin1Dollar());
				break;
			default:
				return null;
			}
		}
		
		return result;
		
	}
	 
	public static final int greatestBillValue(List<CASH_BILL> par1) {
		
		List<Float> values = new ArrayList<Float>();
		
		for (CASH_BILL var: par1) {
			values.add(var.value);
		}
		
		float greatest = 0;
		int index = 0;
		
		for (int i = 0; i < values.size(); i++) {
			if (values.get(i) > greatest) {
				greatest = values.get(i);
			}
			index++;
		}
		
		return index - 1;
		
	}
	
	public static final int greatestCoinValue(List<CASH_COIN> par1) {
		
		List<Float> values = new ArrayList<Float>();
		
		for (CASH_COIN var: par1) {
			values.add(var.value);
		}
		
		float greatest = 0;
		int index = 0;
		
		for (int i = 0; i < values.size(); i++) {
			if (values.get(i) > greatest) {
				greatest = values.get(i);
			}
			index++;
		}
		
		return index - 1;
		
	}
	
	public static final IWalletItem greatestItemValue(List<IWalletItem> par1) {
		
		List<Float> values = new ArrayList<Float>();
		for (IWalletItem var: par1) {
			values.add(var.getValue());
		}
		
		float greatest = 0;
		int greatIndex = 0;
		
		for (float var: values) {
			
			int i = 0;	
			i++;
			
			if (var > greatest) {
				greatest = var;
				greatIndex = i++;
			}
			
		}
		
		return par1.get(greatIndex);
		
	}
	
	public static final IWalletItem lowestItemValue(List<IWalletItem> par1) {
		
		List<Float> values = new ArrayList<Float>();
		for (IWalletItem var: par1) {
			values.add(var.getValue());
		}
		
		float lowest = 0;
		int lowIndex = 0;
		
		for (Float var: values) {
			
			int i = 0;
			i++;
			
			if (var < lowest) {
				lowest = var;
				lowIndex = i;
			}
			
		}
		
		return par1.get(lowIndex);
		
	}
	
}
