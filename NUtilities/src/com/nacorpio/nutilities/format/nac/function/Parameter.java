package com.nacorpio.nutilities.format.nac.function;

import com.nacorpio.nutilities.format.nac.type.Super;

/**
 * Represents a parameter in a function/method.
 * @author Nacorpio
 *
 */
public class Parameter {

	String name;
	Super type;
	
	public Parameter(String par1, Super par2) {
		this.name = par1;
		this.type = par2;
	}
	
	/**
	 * Returns the name of the parameter.
	 * @return the name.
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Returns the type of this parameter.
	 * @return the type.
	 */
	public Super getType() {
		return this.type;
	}
	
}
