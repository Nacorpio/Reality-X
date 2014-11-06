package com.nacorpio.nutilities.math.util;

public class Rectangle {

	private Line l1;
	private Line l2;
	private Line l3;
	private Line l4;
	
	private Vector2 start;
	
	private float height;
	private float width;
	
	public Rectangle(Vector2 par1, float par2, float par3) {
		
		start = par1;
		
		float startX = start.x;
		float startY = start.y;
			
		height = par2;
		width = par3;
		
		l1 = new Line(startX, startY, startX, startY + height);
		l2 = new Line(startX, startY + height, startX + width, startY + height);
		l3 = new Line(startX + width, startY + height, startX + width, startY);
		l4 = new Line(startX + width, startY, startX, startY);
		
	}
	
	/**
	 * Returns the lines included inside this rectangle.
	 * @return the lines.
	 */
	public final Line[] lines() {
		return new Line[] {l1, l2, l3, l4};
	}
	
	/**
	 * Returns the X-coordinate where the rectangle begins.
	 * @return the xMin.
	 */
	public final float xMin() {
		return start.x;
	}
	
	/**
	 * Returns the Y-coordinate where the rectangle begins.
	 * @return the yMin.
	 */
	public final float yMin() {
		return start.y;
	}
	
	/**
	 * The X-coordinate of where the width reaches.
	 * @return the xMax.
	 */
	public final float xMax() {
		return start.x + width;
	}
	
	/**
	 * The Y-coordinate of where the height reaches. 
	 * @return the yMax.
	 */
	public final float yMax() {
		return start.y + height;
	}
	
	/**
	 * Returns the area of the rectangle.
	 * @return the area.
	 */
	public final float area() {
		return height * width;
	}

	/**
	 * Returns the exact middle-point of the rectangle.
	 * @return the center.
	 */
	public final Vector2 center() {
		return new Vector2(width / 2, height / 2);
	}
	
	/**
	 * Returns whether the specified rectangle overlaps the rectangle.
	 * @param par1 the rectangle.
	 * @return true/false.
	 */
	public final boolean intersects(Rectangle par1) {
		return (Math.abs(xMin() - par1.xMin()) * 2 < (xMax() + par1.xMax())) &&
			   (Math.abs(yMin() - par1.yMin()) * 2 < (yMax() + par1.yMax()));
	}
	
	/**
	 * Returns whether the specified vector is inside of the rectangle.
	 * @param par1 the vector.
	 * @return true/false.
	 */
	public final boolean inside(Vector2 par1) {
		return l1.right(par1) && l2.below(par1) && l3.left(par1) && l4.above(par1);
	}

	/**
	 * Returns whether the specified rectangle is inside of the rectangle.
	 * @param par1 the rectangle.
	 * @return true/false.
	 */
	public final boolean inside(Rectangle par1) {
		return inside(par1.l1.start()) && inside(par1.l1.end()) &&
			   inside(par1.l2.start()) && inside(par1.l2.end()) &&
			   inside(par1.l3.start()) && inside(par1.l3.end()) &&
			   inside(par1.l4.start()) && inside(par1.l4.end());
	}
	
}
