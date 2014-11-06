package com.nacorpio.traffic.util;

public final class StringUtil {

	/**
	 * Joins the specified array into a String.
	 * @param par1 the divider.
	 * @param par2 the array of objects.
	 * @return the joined array.
	 */
	public static final String join(String par1, Object... par2) {
		String var1 = "";
		for (int i = 0; i < par2.length; i++) {
			if (i < par2.length - 1) {
				var1 += par2[i].toString() + par1;
			} else {
				var1 += par2[i].toString();
			}
		}
		return var1;
	}
	
	public static final String join(char par1, Object... par2) {
		return join(par1, par2);
	}

	/**
	 * Joins the specified array into a comma separated String.
	 * @param par1 the array of objects.
	 * @return the joined array.
	 */
	public static final String join(Object... par1) {
		return join(", ", par1);
	}
	
}
