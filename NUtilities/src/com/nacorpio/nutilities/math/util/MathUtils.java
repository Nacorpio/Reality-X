package com.nacorpio.nutilities.math.util;

public class MathUtils {

	public static double getPercentage(int subtotal, int total) {
		return ((float) subtotal / (float) total) * 100;
	}
	
	public static double round(double value, int decimals) {
		double p = Math.pow(10, decimals);
		return Math.round(value * p) / p;
	}
	
	public static double average(double... par1) {
		double var1 = 0D;
		for (double var: par1) {
			var1 += var;
		}
		return var1 / par1.length;
	}
	
	public static float average(float... par1) {
		float var1 = 0F;
		for (float var: par1) {
			var1 += var;
		}
		return var1 / par1.length;
	}
	
	public static int average(int... par1) {
		int var1 = 0;
		for (int var: par1) {
			var1 += var;
		}
		return var1 / par1.length;
	}
	
}
