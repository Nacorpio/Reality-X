package com.nacorpio.nutilities.wrapper;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class WArray {
	
	Object[] array;
	
	public WArray(Collection<?> par1) {
		for (int i = 0; i < par1.size(); i++) {
			array[i] = par1.toArray()[i];
		}
	}
	
	public WArray(Object... par1) {
		this.array = par1;
	}
	
	public final Object add(Object par1) {
		if (array != null)
			return Arrays.asList(array).add(par1);
		return null;
	}
	
	public final Object remove(Object par1) {
		if (array != null)
			return Arrays.asList(array).remove(par1);
		return null;
	}
	
	public final Object remove(int par1) {
		if (array != null)
			return Arrays.asList(array).remove(par1);
		return null;
	}
	
	public final String toString() {
		String var1 = "";
		for (int i = 0; i < array.length; i++) {
			Object varObject1 = array[i];
			if (i < array.length - 1) {
				var1 += varObject1 + ", ";
			} else {
				var1 += varObject1;
			}
		}
		return var1;
	}
	
	public final Object[] toArray() {
		return array;
	}
	
	public final List<?> toList() {
		return Arrays.asList(array);
	}
	
}
