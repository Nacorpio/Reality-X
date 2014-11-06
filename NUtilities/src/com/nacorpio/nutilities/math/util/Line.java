package com.nacorpio.nutilities.math.util;

public class Line {

	private Vector2 start;
	private Vector2 end;
	
	public Line(float par1, float par2, float par3, float par4) {
		start = new Vector2(par1, par2);
		end = new Vector2(par3, par4);
	}
	
	public Line(Vector2 par1, Vector2 par2) {
		this(par1.x(), par1.y(), par2.x(), par2.y());
	}

	/**
	 * Returns the starting vector of the line.
	 * @return the starting vector.
	 */
	public Vector2 start() {
		return start;
	}
	
	/**
	 * Set the start vector.
	 * @param par1 the vector.
	 */
	public final void setStart(Vector2 par1) {
		start = par1;
	}
	
	/**
	 * Set the start vector.
	 * @param par1 the X-coordinate.
	 * @param par2 the Y-coordinate.
	 */
	public final void setStart(float par1, float par2) {
		setStart(new Vector2(par1, par2));
	}
	
	/**
	 * Set the end vector.
	 * @param par1 the vector.
	 */
	public final void setEnd(Vector2 par1) {
		end = par1;
	}
	
	/**
	 * Set the end vector.
	 * @param par1 the X-coordinate.
	 * @param par2 the Y-coordinate.
	 */
	public final void setEnd(float par1, float par2) {
		setEnd(new Vector2(par1, par2));
	}
	
	/**
	 * Returns the ending vector of the line.
	 * @return the ending vector.
	 */
	public Vector2 end() {
		return end;
	}
	
	/**
	 * Returns the distance between the xMin and xMax.
	 * @return the x distance.
	 */
	public final float distanceX() {
		return Math.max(end.x, start.x) - Math.min(end.x, start.x);
	}
	
	/**
	 * Returns the distance between the yMin and yMax.
	 * @return the y distance.
	 */
	public final float distanceY() {
		return Math.max(end.y, start.y) - Math.min(end.y, start.y);
	}
	
	/**
	 * Returns the slope of this line.
	 * @return the slope.
	 */
	public final float slope() {
		return (Math.max(end.y, start.y) - Math.min(end.y, start.y)) /
			   (Math.max(end.x, start.x) - Math.min(end.x, start.x));
	}

	/**
	 * Returns whether the specified vector is on the line.
	 * @param par1 the vector.
	 * @return true/false.
	 */
	public final boolean on(Vector2 par1) {
		return start.x == par1.x ||
			   start.y == par1.y ||
			   end.x == par1.x ||
			   end.y == par1.y;
	}
	
	/**
	 * Returns whether the specified vector is on the left side of the line.
	 * @param par1 the vector.
	 * @return true/false.
	 */
	public final boolean left(Vector2 par1) {
		return par1.x < start.x && par1.x < end.x;
	}
	
	/**
	 * Returns whether the specified vector is below the line.
	 * @param par1 the vector.
	 * @return true/false.
	 */
	public final boolean below(Vector2 par1) {
		return par1.y < start.y && par1.y < end.y;
	}
	
	/**
	 * Returns whether the specified vector is above the line.
	 * @param par1 the vector.
	 * @return true/false.
	 */
	public final boolean above(Vector2 par1) {
		return par1.y > start.y && par1.y > end.y;
	}
	
	/**
	 * Returns whether the specified vector is on the right side of the line.
	 * @param par1 the vector.
	 * @return true/false.
	 */
	public final boolean right(Vector2 par1) {
		return par1.x > start.x && par1.x > end.x;
	}
	
	/**
	 * Returns whether the line is above the specified line.
	 * @param par1 the line to compare.
	 * @return true/false.
	 */
	public final boolean above(Line par1) {
		return par1.end.x < end.x && par1.end.y < end.y &&
				   par1.start.x < start.x && par1.start.y < start.y;
	}
	
	/**
	 * Returns whether the line is below the specified line.
	 * @param par1 the line to compare.
	 * @return true/false.
	 */
	public final boolean below(Line par1) {
		return par1.end.x > end.x && par1.end.y > end.y &&
			   par1.start.x > start.x && par1.start.y > start.y;
	}
	
	/**
	 * Returns whether the start-vec is connected to the specified line.
	 * @param par1 the line.
	 * @return true/false.
	 */
	public final boolean isLinkedWithStart(Line par1) {
		return par1.start().equals(start()) || par1.start().equals(end());
	}
	
	/**
	 * Returns whether the line is connected to the specified line in any way.
	 * @param par1 the line.
	 * @return true/false.
	 */
	public final boolean isLinkedWith(Line par1) {
		return isLinkedWithStart(par1) || isLinkedWithEnd(par1);
	}
	
	/**
	 * Returns whether the end-vec is connected to the specified line.
	 * @param par1 the line.
	 * @return true/false.
	 */
	public final boolean isLinkedWithEnd(Line par1) {
		return par1.end().equals(end()) || par1.end().equals(start());
	}
	
	/**
	 * Returns the center of the line.
	 * @return the center.
	 */
	public final Vector2 center() {
		return new Vector2(distanceX() / 2, distanceY() / 2);
	}
	
	public final boolean equals(Object par1) {
		
		if (par1 == null) {
			return false;
		}
		
		if (par1 instanceof Line) {
			
			Line var1 = (Line) par1;
			return var1.start.equals(start) && var1.end.equals(end);
			
		}
		
		return par1.equals(this);
		
	}
	
}
