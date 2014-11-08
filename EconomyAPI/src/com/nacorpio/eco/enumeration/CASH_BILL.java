package com.nacorpio.eco.enumeration;

import java.util.ArrayList;
import java.util.List;

import com.nacorpio.eco.IWalletItem;
import com.nacorpio.eco.cash.BillFifty;
import com.nacorpio.eco.cash.BillFive;
import com.nacorpio.eco.cash.BillHundred;
import com.nacorpio.eco.cash.BillOne;
import com.nacorpio.eco.cash.BillTen;
import com.nacorpio.eco.cash.BillTwenty;

public enum CASH_BILL {
	
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