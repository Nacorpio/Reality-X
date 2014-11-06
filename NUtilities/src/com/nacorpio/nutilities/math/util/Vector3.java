package com.nacorpio.nutilities.math.util;

/**
 * Represents a point which allows X, Y and Z coordinates as input.<br>
 * These will also be used when creating other types of shapes.
 * @author Nacorpio
 *
 */
public class Vector3 {

	float x;
	float y;
	float z;
	
	public Vector3(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
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
	
	/**
	 * Returns the Z-coordinate of the point.
	 * @return the Z-coordinate.
	 */
	public float z() {
		return z;
	}
	
}
