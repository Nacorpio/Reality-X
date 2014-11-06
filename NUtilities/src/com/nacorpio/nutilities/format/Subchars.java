package com.nacorpio.nutilities.format;

public final class Subchars {

	public static final char getSuperscript(char par1) {
		
		String c1 = "ᴬᴮᴰᴱᴳᴴᴵᴶᴷᴸᴹᴺᴼᴾᴿᵀᵁ ";
		String c2 = "ABDEGHIJKLMNOPRTU";
		
		for (int i = 0; i < c2.length(); i++) {
			if (c2.charAt(i) == par1)
				return c1.charAt(i);
		}
		
		return '#';
		
	}
	
	public static final char getSubint(char par1) {
		
		String c1 = "₀₁₂₃₄₅₆₇₈₉";
		String c2 = "0123456789";
		
		for (int i = 0; i < c2.length(); i++) {
			if (c2.charAt(i) == par1)
				return c1.charAt(i);
		}
		
		return '#';
		
	}
	
}
