package com.nacorpio.nutilities.math.util;

/**
 * Represents a Vector which allows X and Y coordinates as input.<br>
 * These will also be used when creating other types of shapes.
 * @author Nacorpio
 *
 */
public class Vector2 {

	float x;
	float y;
	
	/**
	 * Creates a new two-dimensional Vector.
	 * @param x the X-coordinate.
	 * @param y the Y-coordinate.
	 */
	public Vector2(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Creates a new two-dimensional Vector.
	 */
	public Vector2() {
		this(0.0F, 0.0F);
	}
	
	/**
	 * Scale the Vector.
	 * @param par1 the new scale.
	 */
	public void scale(float par1) {
		if (par1 > 0) {
			x = x * par1;
			y = y * par1;
		}		
	}
	
	/**
	 * Returns the magnitude of the Vector.
	 * @return the magnitude.
	 */
	public float magnitude() {
		return (float) Math.sqrt(Math.pow((double) x, 2) + Math.pow((double) y, 2));
	}
	
	/**
	 * Returns whether this point is a null vector.
	 * @return true/false.
	 */
	public boolean isNullVector() {
		return magnitude() == 0;
	}
	
	/**
	 * Returns whether this point is a unit vector.
	 * @return true/false.
	 */
	public boolean isUnitVector() {
		return magnitude() == 1;
	}
	
	/**
	 * Add the specified amount of units to the X-axis.
	 * @param par1 units to add.
	 */
	public final void addX(float par1) {x += par1;}

	/**
	 * Add the specified amount of units to the Y-axis.
	 * @param par1 units to add.
	 */
	public final void addY(float par1) {y += par1;}
	
	/**
	 * Subtract the specified amount of units from the X-axis.
	 * @param par1 units to subtract.
	 */
	public final void subX(float par1) {x -= par1;}
	
	/**
	 * Subtract the specified amount of units from the Y-axis.
	 * @param par1 units to subtract.
	 */
	public final void subY(float par1) {y -= par1;}
	
	/**
	 * Set the X-coordinate of the Vector.
	 * @param par1 the X-coordinate.
	 */
	public final void setX(float par1) {x = par1;}
	
	/**
	 * Set the Y-coordinate of the Vector.
	 * @param par1 the Y-coordinate.
	 */
	public final void setY(float par1) {y = par1;}
	
	/**
	 * Returns the X-coordinate of the point.
	 * @return the X-coordinate.
	 */
	public float x() {
		return x;
	}
	
	/**
	 * Returns the Y-coordinate of the point.
	 * @return the Y-coordinate.
	 */
	public float y() {
		return y;
	}
	
	public final boolean equals(Object par1) {
		
		if (par1 == null) {
			return false;
		}
		
		if (par1 instanceof Vector2) {
			
			Vector2 var1 = (Vector2) par1;
			return var1.x == x && var1.y == y;
			
		}
		
		return par1.equals(this);
		
	}
	
	public final String toString() {
		return "{" + x + ", " + y + "}";
	}
	
}
