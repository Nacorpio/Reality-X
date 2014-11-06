package com.nacorpio.nutilities.conversion;

public final class Currency {

	public static enum CURRENCY {
		
		EUR(0.739386F),
		GBP(0.584749F),
		INR(60.1870F),
		AUD(1.06718F),
		CAD(1.07580F),
		AED(3.67325F),
		SEK(6.82481F),
		NOK(6.19527F);
		
		private float usdValue;
		CURRENCY(float par1) {
			usdValue = par1;
		}
		
		public final CURRENCY get(String par1) {
			for (CURRENCY var: values()) {
				if (var.toString().equalsIgnoreCase(par1))
					return var;
			}
			return null;
		}
		
		public final float getUSDValue() {
			return usdValue;
		}
		
	}
	
	public static final float toUSD(float par1, CURRENCY par2) {
		return par1 * par2.getUSDValue();
	}
	
}
