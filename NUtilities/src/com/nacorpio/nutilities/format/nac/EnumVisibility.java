package com.nacorpio.nutilities.format.nac;

public enum EnumVisibility {

	STATIC("static"),
	FINAL("final");
	
	String name;
	EnumVisibility(String par1) {
		name = par1;
	}
	
	public final String getName() {
		return name;
	}
	
	public final EnumVisibility getByName(String par1) {
		for (EnumVisibility var: values()) {
			if (var.getName().equalsIgnoreCase(par1))
				return var;
		}
		return null;
	}
	
}
