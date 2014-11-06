package com.nacorpio.nutilities.math.parser;

public abstract class Element {

	public static enum EnumType {
		OPERAND,
		VARIABLE
	}
	
	private int position;
	private EnumType type;
	
	public Element(int par1, EnumType par2) {
		position = par1;
		type = par2;
	}
	
	public final int getPosition() {
		return position;
	}
	
	public final EnumType getType() {
		return type;
	}
	
}
