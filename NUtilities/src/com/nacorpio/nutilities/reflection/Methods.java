package com.nacorpio.nutilities.reflection;

import java.lang.reflect.InvocationTargetException;

public final class Methods {

	public static final Object call(Class<?> par1, String par2, Object... par3) {
		
		try {
			return par1.getMethod(par2).invoke("CALLER", par3);
		}
		
		catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		
		catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		
		catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
