package com.nacorpio.eco;

import com.nacorpio.eco.bank.Wallet;
import com.nacorpio.eco.cash.CashUtil;

public class Economy {

	public static final float TAX_PERCENTAGE = 2.5F;

	public static void main(String[] par1) throws InstantiationException, IllegalAccessException {
		for (IWalletItem var: CashUtil.calculateCash(125)) {
			System.out.println(var.getName());
		}
	}
	
}
