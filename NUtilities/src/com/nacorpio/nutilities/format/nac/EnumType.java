package com.nacorpio.nutilities.format.nac;

public enum EnumType {

	CLASS("class"),
	CLASS_ABS("abstract class"),
	INTERFACE("interface"),
	ENUM("enum"),
	VOID("void"),
	FUNCTION("function");
	
	String name;
	EnumType(String par1) {
		name = par1;
	}
	
	public final String getName() {
		return name;
	}
	
	public final EnumType getByName(String par1) {
		for (EnumType var: values()) {
			if (var.getName().equalsIgnoreCase(par1))
				return var;
		}
		return null;
	}
	
}
