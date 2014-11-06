package com.nacorpio.nutilities.string;

import com.nacorpio.nutilities.regex.RegularExpression;

public class TextUtils {

	// Get decimals: \d*(?:,?)(\d*)
	
		public static final boolean isHtmlTag(String par1) {
			return par1.matches("<([A-z]*)\\s*(.*)?>((?:.*\\s*)*)<\\/([A-z]*)>");
		}
		
		public static final String getHtmlContent(String par1) {
			RegularExpression r = new RegularExpression("<([A-z]*)\\s*(.*)?>((?:.*\\s*)*)<\\/([A-z]*)>");
			return r.getMatches(par1).get(2).value();
		}
		
		public static final String getXmlContent(String par1) {
			RegularExpression r = new RegularExpression("<([A-z]*)>((?:\\s*.*)*)<\\/([A-z]*)>");
			return r.getMatches(par1).get(0).group(1).value();
		}
		
		public static final boolean isXmlTag(String par1) {
			return par1.matches("<([A-z]*)>((?:\\s*.*)*)<\\/([A-z]*)>");
		}
		
		public static final boolean isPath(String par1) {
			return par1.matches("([A-z]:)(\\(?:.*\\?(?:[A-z0-9]*(?:\\.[A-z0-9]))?))?");
		}
		
		public static final boolean isUrl(String par1) {
			return par1.matches("((http(?:s)?|[A-z]*):\\/\\/(?:www.|[A-z]*)([A-z0-9-.]*)(\\/.*))?");
		}
		
		public static final boolean isHtmlAttribute(String par1) {
			return par1.matches("([A-z1-9]*)=\"([A-z1-9]*?)\"");
		}
		
		public static final boolean isJavaScriptFunc(String par1) {
			return par1.matches("function (.*?)\\(([A-z0-9,\\s]*\\,*?)\\)\\s*{(?:\\s*?(.*?\n*.*?)\n*\\s*?)}");
		}
		
		public static final boolean isJavaClass(String par1) {
			return par1.matches("(public|private)?\\s*(static|[A-z]*)?\\s*class\\s*([A-z]*)\\s*{(\\s.*)*}");
		}
		
		public static final boolean isJavaScriptIfCond(String par1) {
			return par1.matches("if\\s*\\((.*)\\)\\s*?{(\n*.*\n)*}(?:\\s*else\\s*{(\n.*)*})?");
		}
	
		public static final boolean isDigits(String par1) {
			boolean var1 = true;
			for (int i = 0; i < par1.length(); i++) {
				if (Character.isDigit(par1.charAt(i))) {
					continue;
				} else {
					return false;
				}
			}
			return var1;
		}
		
		public static final boolean isEven(int par1) {
			if (par1 % 2 == 0) {
				return true;
			} else {
				return false;
			}
		}
		
		public static final int toInteger(char par1) {
			return Integer.parseInt(String.valueOf(par1));
		}
	
		public static final boolean isMastercard(String par1) {
			if ((par1.startsWith("51") || par1.startsWith("52") || par1.startsWith("53") || par1.startsWith("54") || par1.startsWith("55")) &&
				(par1.length() >= 16 && par1.length() <= 19)) {
				return true;
			}
			return false;
		}
		
}
