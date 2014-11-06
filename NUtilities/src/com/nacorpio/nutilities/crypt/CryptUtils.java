package com.nacorpio.nutilities.crypt;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CryptUtils {

	private static final String ALPHA = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String ALPHA_L = ALPHA.toLowerCase();
	private static final String NUMERIC = "0123456789";
	private static final String SPECIAL = "@£$€{[]}!\\\"#¤%&/()=?-.,+<>|;:_";
	
	public static final String session(Date par1) {
		return "[" + par1 + "]";
	}
	
	public static final boolean validate(String par1) {
		return false;
	}
	
	public static final String deconfuseNumeric1(String par1) {
		
		String var1 = "";
		
		for (int i = 0; i < par1.length(); i++) {
			var1 += ALPHA_L.charAt(par1.charAt(i));
		}
		
		return var1;
		
	}
	
	public static final String confuse1(String par1) {
		return reverse(shiftUp(par1, 3));
	}
	
	public static final String confuseNumeric1(String par1) {
		
		String var1 = "";
		
		for (int i = 0; i < par1.length(); i++) {
			var1 += "[" + ALPHA.indexOf(par1.charAt(i)) + "]";
		}
		
		return var1;
		
	}
	
	public static final String confuse2(String par1) {
		return confuse1(reverse(par1));
	}

	public static final String confuse3(String par1) {
		return confuse2(shiftDown(par1, 12));
	}
	
	public static final String deconfuse3(String par1) {
		return deconfuse2(shiftUp(par1, 12));
	}
	
	public static final String deconfuse2(String par1) {
		return deconfuse1(reverse(par1));
	}
	
	public static final String deconfuse1(String par1) {
		return reverse(shiftDown(par1, 3));
	}

	public static final String junk(int par2) {
		return junk(System.currentTimeMillis(), (par2 > 0 ? par2 : par2++));
	}
	
	public static final String junk(long par1, int par2) {
		
		int var1 = 0;
		Random varRandom1 = new Random(par1);
		
		String var2 = "";
		
		for (int i = 0; i < par2; i++) {
			int varSpecial1 = varRandom1.nextInt(SPECIAL.length() - 1);
			var1 = varRandom1.nextInt(ALPHA.length() - 1);
			if (varRandom1.nextBoolean() == true) {
				var2 += ALPHA.charAt(var1);
			} else {
				var2 += SPECIAL.charAt(varSpecial1);
			}
		}
		
		return var2;
			
	}
	
	public static final char pickUpper(long par1) {
		return Character.toUpperCase(pickLower(par1));
	}
	
	public static final char pickLower(long par1) {
		return ALPHA.charAt(new Random(par1).nextInt(ALPHA.length() - 1));
	}
	
	public static final String reverse(String par1) {
		String var1 = "";
		for (int i = par1.length() - 1; i >= 0; i--) {
			var1 += par1.charAt(i);
		}
		return var1;
	}
	
	public static final String shiftUp(String par1, int par2) {
		String var1 = "";
		for (int i = 0; i < par1.length(); i++) {
			int pos = getIndex(par1.charAt(i));
			var1 += getAlpha(bounceUp(pos + par2, 25));
		}
		return var1;
	}
	
	public static final String shiftDown(String par1, int par2) {
		String var1 = "";
		for (int i = 0; i < par1.length(); i++) {
			int pos = getIndex(par1.charAt(i));
			var1 += getAlpha(bounceDown(par2 - pos, 0));
		}
		return var1;
	}
	
	public static final int bounceUp(int par1, int par2) {
		return (par1 > par2 ? par1 - par2 : par1);
	}
	
	public static final int bounceDown(int par1, int par2){
		return (par1 < par2 ? par2 - par1 : par1);
	}
	
	public static final int getIndex(char par1) {
		for (int i = 0; i < ALPHA.length(); i++) {
			if (ALPHA.charAt(i) == par1)
				return i;
		}
		return -1;
	}
	
	public static final char getAlpha(int par1) {
		return ALPHA.charAt(par1);
	}
	
	public static final char getAlphaLower(int par1) {
		return ALPHA_L.charAt(par1);
	}
	
}
