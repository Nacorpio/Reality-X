package com.nacorpio.nutilities.string;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public final class StringUtils {

	public static final String join(Collection<?> par1, char par2, boolean par3) {
		
		String var1 = "";
		
		for (int i = 0; i < par1.size(); i++) {
			if (i < par1.size() - 1) {
				var1 += par1.toArray()[i].toString() + par2 + (par3 ? " " : "");
			} else {
				var1 += par1.toArray()[i].toString();
			}
		}
		
		return var1;
		
	}
	
	/**
	 * Returns the String representation of the specified array.
	 * @param par1 the array.
	 * @param par2 the char to separate the elements with.
	 * @param par3 whether to use a whitespace after every element.
	 * @return the String representation.
	 */
	public static final String join(Object[] par1, char par2, boolean par3) {
		
		String var1 = "";
		
		for (int i = 0; i < par1.length; i++) {
			if (i < par1.length - 1) {
				var1 += par1[i].toString() + par2 + (par3 ? " " : "");
			} else {
				var1 += par1[i];
			}
		}
		
		return var1;
		
	}
	
	/**
	 * Returns whether the specified String has a number at the beginning.
	 * A boolean value of "true" is returned if a number is being represented in the beginning of the String.
	 * If not, then a boolean value of "false" is returned.
	 * @param s the String.
	 * @return true/false.
	 */
	public boolean isNoNumberAtBeginning(String s){
		return s.matches("^[^\\d].*");
	}
	
	/**
	 * Returns whether the specified character is being presented in the beginning of the specified String.
	 * A boolean value of "true" is returned if the character specified is being returned in the beginning of the String.
	 * If not, a boolean value of "false" is returned.
	 * @param par1 the String.
	 * @param par2 the Character.
	 * @return true/false.
	 */
	public boolean isCharAtBeginning(String par1, char par2) {
		return par1.matches("^[^" + par2 + "].*");
	}
	
	/**
	 * Returns the comma separated version of the specified array.
	 * @param par1 the array.
	 * @return the String representation.
	 */
	public static final String join(String... par1) {
		return join(par1, ',', true);
	}
	
	/**
	 * Returns the comma separated version of the specified collection.
	 * @param par1 the collection.
	 * @return the String representation.
	 */
	public static final String join(Collection<?> par1) {
		return join(par1, ',', true);
	}
	
	/**
	 * Returns whether the specified String is empty.
	 * @param par1 the String.
	 * @return true/false.
	 */
	public static final boolean isEmpty(String par1) {
		return par1.isEmpty() || par1.length() == 0 || par1 == null;
	}
	
	/**
	 * Returns whether the specified Object is empty.
	 * @param par1 the Object.
	 * @return true/false.
	 */
	public static final boolean isEmpty(Object par1) {
		return isEmpty(par1.toString()) || par1 == null;
	}
	
	/**
	 * Returns whether the specified Collection is empty.
	 * @param par1 the Collection.
	 * @return true/false.
	 */
	public static final boolean isEmpty(Collection<?> par1) {
		return par1.size() == 0 || par1 == null;
	}
	
	/**
	 * Returns whether the specified Array is empty. 
	 * @param par1 the Array.
	 * @return true/false.
	 */
	public static final boolean isEmpty(Object... par1) {
		return par1.length == 0 || par1 == null;
	}
	
}
