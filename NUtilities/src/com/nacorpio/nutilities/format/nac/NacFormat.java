package com.nacorpio.nutilities.format.nac;

import com.nacorpio.nutilities.regex.RegularExpression;

public final class NacFormat {

	public static final RegularExpression getNAbstractFunction() {
		return new RegularExpression("([A-z]*)\\s*([A-z\\[\\]]*)\\s*(\\(.*\\));");
	}
	
	public static final boolean isNAbstractFunction(String par1) {
		return par1.matches("([A-z]*)\\s*([A-z\\[\\]]*)\\s*(\\(.*\\));");
	}
	
	public static final RegularExpression getNFunction() {
		return new RegularExpression("([A-z]*)\\s*([A-z]*)\\s*(\\(.*\\))\\s*{((?:\\s*.*)*)}");
	}
	
	public static final boolean isNFunction(String par1) {
		return par1.matches("([A-z]*)\\s*([A-z]*)\\s*(\\(.*\\))\\s*{((?:\\s*.*)*)}");
	}
	
	public static final RegularExpression getNVariable() {
		return new RegularExpression("(int|string|float|double|long|short|object)\\s*([A-z]*)\\s*=?\\s*?(null|[A-z]*)?;");
	}
	
	public static final boolean isNVariable(String par1) {
		return par1.matches("(int|string|float|double|long|short|object)\\s*([A-z]*)\\s*=?\\s*?(null|[A-z]*)?;");
	}
	
	public static final boolean isNCall(String par1) {
		return par1.matches("((?:(?:[A-z0-9]*).?)*);");
	}
	
	public static final boolean isNXMLTag(String par1) {
		return par1.matches("<((?:void|[A-z0-9]*):?[A-z0-9]*)\\s*(.*)>((?:\\s*.*)*)<\\/(.*)>");
	}
	
	public static final boolean isNXMLImport(String par1) {
		return par1.matches("<import\\s*lib=\"[A-z0-9]*\">");
	}
	
	public static final RegularExpression getNXMLVoid() {
		return new RegularExpression("<(void:?([A-z0-9]*))\\s*(.*)>((?:\\s*.*)*)<\\/(.*)>");
	}
	
	public static final RegularExpression getNCall() {
		return new RegularExpression("((?:(?:[A-z0-9]*).?)*);");
	}
	
}
