package com.nacorpio.eco.cash;

import java.util.ArrayList;
import java.util.List;

import com.nacorpio.eco.IWalletItem;
import com.nacorpio.eco.bank.Wallet.CASH_BILL;
import com.nacorpio.eco.bank.Wallet.CASH_COIN;

public class CashUtil {
	
	public static final List<IWalletItem> calculateChange(float par1, float par2) {
		if (par2 >= par1) {		
			float change = par2 - par1;
			return calculateCash(change);	
		}
		return null;
	}
	 
	public static final List<IWalletItem> calculateCash(float par1) {
		
		List<IWalletItem> result = new ArrayList<IWalletItem>();
		
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
		
		for (CASH_BILL var: bills) {
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
		
		for (CASH_COIN var: coins) {
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
	
	public static final IWalletItem greatestValue(List<IWalletItem> par1) {
		
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
	
	public static final IWalletItem lowestValue(List<IWalletItem> par1) {
		
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
