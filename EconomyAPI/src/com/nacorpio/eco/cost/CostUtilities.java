package com.nacorpio.eco.cost;

import com.nacorpio.eco.Economy;

public final class CostUtilities {

	public static final float getCashHandle(Object par1, float par2) {
		return par2 + (par2 * Economy.TAX_PERCENTAGE / 100);
	}
	
}
