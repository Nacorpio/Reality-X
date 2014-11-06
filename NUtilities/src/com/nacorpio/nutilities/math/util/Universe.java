package com.nacorpio.nutilities.math.util;

import java.util.HashMap;
import java.util.Map;

/**
 * The universe is deprecated because it's a <b>WIP</b>.
 * @author Nacorpio
 *
 */
@Deprecated
public class Universe extends Rectangle {

	private String name;
	private Map<String, ObjectPosition> objects = new HashMap<String, ObjectPosition>();
	
	/**
	 * Creates a new universe with the specified name.
	 * @param par1 the name.
	 * @param par2 the height.
	 * @param par3 the width.
	 */
	public Universe(String par1, float par2, float par3) {
		super(new Vector2(0, 0), par2, par3);
	}
	
	/**
	 * Adds a new object to the universe.
	 * @param par1 the name of the object.
	 * @param par2 the object (can be anything).
	 * @param par3 the X-coordinate.
	 * @param par4 the Y-coordinate.
	 * @param par5 the spawn-coordinates.
	 */
	public final void add(String par1, Object par2, float par3, float par4, Vector2 par5) {
		if (!objects.containsKey(par1)) {
			objects.put(par1, new ObjectPosition(par2, par3, par4, par5));
		}
	}
	
	/**
	 * Returns the name of the universe.
	 * @return the name.
	 */
	public String getName() {
		return name;
	}
	
}
