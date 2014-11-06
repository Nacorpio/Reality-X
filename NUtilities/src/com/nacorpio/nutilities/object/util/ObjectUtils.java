package com.nacorpio.nutilities.object.util;

public final class ObjectUtils {

	public final static boolean equals(Object par1, Object par2) {
		if (par1 instanceof String) {
			
			String var1 = (String) par1;
			return var1.equals(par2);
			
		} else if (par1 instanceof Integer) {
			
			Integer var1 = (Integer) par1;
			return var1.equals(par2);
			
		} else if (par1 instanceof Double) {
			
			Double var1 = (Double) par1;
			return var1.equals(par1);
			
		} else if (par1 instanceof Object[]) {
			
			Object[] var1 = (Object[]) par1;
			boolean var2 = false;
			
			for (Object var: var1) {
				if (equals(par1, var)) {
					var2 = true;
				} else {
					continue;
				}
			}
			
			return var2;
			
		}
		
		return par1.equals(par2);
		
	}
	
}
