package com.nacorpio.nutilities.math.parser;

public class Variable extends Element {

	private char symbol;
	private double value;
	
	public Variable(int par1, char par2, double par3) {
		super(par1, EnumType.VARIABLE);
		symbol = par2;
		value = par3;
	}

	/**
	 * Returns the symbol of this variable.
	 * @return the symbol.
	 */
	public final char getSymbol() {
		return symbol;
	}
	
	/**
	 * Returns the value for the specified amount of instances of this variable.
	 * @param par1 the quantity.
	 * @return the final value.
	 */
	public final double getValue(double par1) {
		return value * par1;
	}
	
	/**
	 * Returns the value of this variable.
	 * @return the value.
	 */
	public final double getValue() {
		return value;
	}
	
}
