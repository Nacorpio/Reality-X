package com.nacorpio.nutilities.format.n;

public enum EnumVariableType {

	CONSTANT(0, 'c'),
	CLOSED(1, 'x'),
	NONE(2);
	
	private int id;
	private char flag;
	
	EnumVariableType(int par1) {
		id = par1;
	}
	
	EnumVariableType(int par1, char par2) {
		id = par1;
		flag = par2;
	}
	
	public final int getId() {
		return id;
	}
	
	public final char getFlag() {
		return flag;
	}
	
}
