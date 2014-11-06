package com.nacorpio.nutilities.conversion;

public enum EnumUnit {

	PERCENT("Percents", "%"),
	CELCIUS("Celcius", "°C"),
	FAHRENHEIT("Fahrenheit", "°F"),
	NEWTON_D("Newton", "°N"),
	RANKINE("Rankine", "°R"),
	REAUMUR("Reaumur", "Re"),
	MICRO_NEWTON("MicroNewton", "µN"),
	PLANCK("Planck", "Θ"),
	CENTIMETERS("Centimeters", "cm"),
	METERS("Meters", "m"),
	MILLIMETERS("Millimeters", "mm"),
	GRAMS("Grams", "g"),
	KILOGRAMS("Kilograms", "kg");
	
	private String name;
	private String suffix;
	
	EnumUnit(String par1, String par2) {
		name = par1;
		suffix = par2;
	}
	
	public final String getName() {
		return name;
	}
	
	public final String getSuffix() {
		return suffix;
	}
	 
	public static final EnumUnit byName(String par1) {
		for (EnumUnit var: values()) {
			if (var.getName().equalsIgnoreCase(par1))
				return var;
		}
		return null;
	}
	
}
