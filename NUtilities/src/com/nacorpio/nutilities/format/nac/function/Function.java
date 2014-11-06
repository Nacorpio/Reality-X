package com.nacorpio.nutilities.format.nac.function;

import com.nacorpio.nutilities.format.nac.EnumAccessibility;
import com.nacorpio.nutilities.format.nac.EnumVisibility;
import com.nacorpio.nutilities.format.nac.type.Super;

public abstract class Function {

	private String name;
	private Super ret;
	private Parameter[] pars;
	
	private EnumVisibility visibility;
	private EnumAccessibility[] accessibility;
	
	/**
	 * Represents a new function that is being called.
	 * @param par1 the name.
	 * @param par2 the type that the function returns.
	 * @param par3 whether the function is abstract.
	 * @param par4 the parameters input to the function.
	 */
	public Function(String par1, Super par2, EnumVisibility par3, EnumAccessibility[] par4, Parameter... par5) {
		this.name = par1;
		this.ret = par2;
		this.visibility = par3;
		this.accessibility = par4;
		this.pars = par5;
	}
	
	/**
	 * Returns the accessibility of this function.
	 * @return the accessibility.
	 */
	public EnumAccessibility[] getAccessibility() {
		return accessibility;
	}
	
	/**
	 * Returns the visibility of this function.
	 * @return the visibility.
	 */
	public EnumVisibility getVisibility() {
		return visibility;
	}
	
	/** 
	 * Invokes the function and returns the value;<br> if the function
	 * is a void, the function always returns null.
	 * @param par1 the parameter values.
	 */
	public abstract Object invoke(Object... par1);
	
	/**
	 * Returns the name of the function.
	 * @return the name.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns the supertype of the function.
	 * @return the supertype.
	 */
	public Super getReturn() {
		return ret;
	}
	
	/**
	 * Returns the parameters in this function.
	 * @return the parameters.
	 */
	public Parameter[] getParameters() {
		return pars;
	}
	
}
