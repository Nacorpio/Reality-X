package com.nacorpio.nutilities.format.nac;

public enum EnumDataFlag {

	PAR("par"),
	BIT8("8"),
	BIT16("16"),
	BIT32("32"),
	BIT64("64");
	
	String name;
	EnumDataFlag(String par1) {
		name = par1;
	}
	
	public final String getName() {
		return name;
	}
	
	public final EnumDataFlag getByName(String par1) {
		for (EnumDataFlag var: values()) {
			if (var.getName().equalsIgnoreCase(par1))
				return var;
		}
		return null;
	}
	
}
