package com.nacorpio.nutilities.math.util;

import java.util.ArrayList;
import java.util.List;

public class LineDrawing {

	private Vector2 start;
	private List<Line> lines = new ArrayList<Line>();
	
	/**
	 * Create a new LineDrawing starting at the specified coordinates.
	 * @param par1 the X-coordinates.
	 * @param par2 the Y-coordinates.
	 */
	public LineDrawing(float par1, float par2) {
		this(new Vector2(par1, par2));
	}
	
	/**
	 * Create a new LineDrawing starting at the specified vector.
	 * @param par1 the vector.
	 */
	public LineDrawing(Vector2 par1) {
		start = par1;
	}
	
	/**
	 * Draw a line from the last line-end to the specified coordinates.
	 * @param par1 the X-coordinate.
	 * @param par2 the Y-coordinate.
	 * @return the LineDrawing for convenience.
	 */
	public final LineDrawing line(float par1, float par2) {
		return line(new Vector2(par1, par2));
	}
	
	/**
	 * Draw a line from the last line-end to the specified vector.
	 * @param par1 the vector.
	 * @return the LineDrawing for convenience.
	 */
	public final LineDrawing line(Vector2 par1) {
		lines.add(new Line((lines.size() > 0 ? last().end() : start), par1));
		return this;
	}
	
	/**
	 * Returns whether the start-vec and end-vec is linked, which means that the shape has an area.
	 * @return true/false.
	 */
	public final boolean isComplete() {
		return last().isLinkedWithStart(lines.get(0));
	}
	
	/**
	 * Returns the start-vec of the drawing.
	 * @return the start-vector.
	 */
	public final Vector2 start() {
		return start;
	}
	
	/**
	 * Returns the drawing's length.
	 * @return the length.
	 */
	public final float circumference() {
		float var1 = 0;
		for (Line var: lines) {
			var1 += var.distanceX();
			var1 += var.distanceY();
		}
		return var1;
	}
	
	/**
	 * Returns whether the shape is triangular.
	 * @return true/false.
	 */
	public final boolean isTriangular() {
		return isComplete() && lines.size() == 3;
	}
	
	/**
	 * Returns a rectangle created by this drawing.<br>
	 * This can only be done if it's rectangular.
	 * @return
	 */
	public final Rectangle getRectangle() {
		if (isRectangular()) {
			return new Rectangle(start(), lines.get(0).distanceY(), lines.get(1).distanceX());
		}
		return null;
	}
	
	/**
	 * Returns whether the shape is rectangular.
	 * @return true/false.
	 */
	public final boolean isRectangular() {
		return isComplete() && lines.size() == 4;
	}
	
	/**
	 * Returns the end-vec of the drawing.
	 * @return the end-vector.
	 */
	public final Vector2 end() {
		return last().end();
	}
	
	/**
	 * Returns the lines of the drawing.
	 * @return the lines.
	 */
	public final Line[] lines() {
		Line[] var1 = new Line[] {};
		return lines.toArray(var1);
	}
	
	/**
	 * Returns the last line of the drawing.
	 * @return the last line.
	 */
	public final Line last() {
		return (lines.size() > 0 ? lines.get(lines.size() - 1) : lines.get(0));
	}
	
}
