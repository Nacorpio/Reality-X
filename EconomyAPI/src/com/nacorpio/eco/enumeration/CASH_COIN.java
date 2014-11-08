package com.nacorpio.eco.enumeration;

import java.util.ArrayList;
import java.util.List;

import com.nacorpio.eco.IWalletItem;
import com.nacorpio.eco.cash.Coin10Cent;
import com.nacorpio.eco.cash.Coin1Cent;
import com.nacorpio.eco.cash.Coin1Dollar;
import com.nacorpio.eco.cash.Coin25Cent;
import com.nacorpio.eco.cash.Coin50Cent;
import com.nacorpio.eco.cash.Coin5Cent;

public enum CASH_COIN {
	
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
