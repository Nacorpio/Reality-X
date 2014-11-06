package com.nacorpio.nutilities.math.util;

public class ObjectPosition extends Rectangle {
	
	private Object obj;
	private Vector2 vec;
	
	public ObjectPosition(Object par1, float par2, float par3, Vector2 par4) {
		super(par4, par2, par3);
		obj = par1;
		vec = par4;
	}
	
	/**
	 * Returns the object.
	 * @return the object.
	 */
	public Object object() {
		return obj;
	}
	
	/**
	 * Returns the vector of the object (location).
	 * @return the vector.
	 */
	public Vector2 getVector() {
		return vec;
	}
	
}
