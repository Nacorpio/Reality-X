package com.nacorpio.traffic.pos;

public enum EnumDirection {

	NORTH(0, 1),	
	SOUTH(0, -1),
	
	SOUTH_WEST(-1, -1),
	NORTH_WEST(-1, 1),
	
	WEST(-1, 0),
	
	SOUTH_EAST(1, -1),
	NORTH_EAST(1, 1),
	
	EAST(1, 0);
	
	private int dx, dy;
	EnumDirection(int par1, int par2) {
		dx = par1;
		dy = par2;
	}
	
	public final int deltaX() {
		return dx;
	}
	
	public final int deltaY() {
		return dy;
	}
	
}
