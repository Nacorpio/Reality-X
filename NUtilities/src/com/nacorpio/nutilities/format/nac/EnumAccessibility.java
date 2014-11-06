package com.nacorpio.nutilities.format.nac;

public enum EnumAccessibility {
	
	PUBLIC("public"),
	PRIVATE("private");
	
	String name;
	EnumAccessibility(String par1) {
		this.name = par1;
	}
	
	public final String getName() {
		return name;
	}
	
	public final EnumAccessibility getByName(String par1) {
		for (EnumAccessibility var: values()) {
			if (var.getName().equalsIgnoreCase(par1))
				return var;
		}
		return null;
	}
	
}
