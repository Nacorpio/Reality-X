package com.nacorpio.traffic.util;

public final class UnitUtil {

	public static final float mpsToBps(float par1) {
		return par1 / 5;
	}
	
	public static final float kmpsToBps(float par1) {
		return mpsToBps(par1) * 1000;
	}
	
	public static final float kmphToBps(float par1) {
		return kmpsToBps(par1) / 60;
	}
	
	public static final float bpsToMps(float par1) {
		return par1 * 5;
	}
	
	public static final float bpsToKmps(float par1) {
		return bpsToMps(par1) / 1000;
	}
	
	public static final float bpsToKmph(float par1) {
		return bpsToKmps(par1) * 60;
	}
	
}
