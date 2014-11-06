package com.nacorpio.traffic.pos;

public class IntPos {

	private int x;
	private int y;
	
	public IntPos(int par1, int par2) {
		x = par1;
		y = par2;
	}
	
	public final IntPos add(EnumDirection par1) {
		return add(par1.deltaX(), par1.deltaY());
	}
	
	public final IntPos addX(int par1) {
		return add(1, 0);
	}
	
	public final IntPos addY(int par1) {
		return add(0, 1);
	}
	
	public final IntPos add(int par1, int par2) {
		x += par1;
		y += par2;
		return this;
	}
	
	public final IntPos subtract(int par1, int par2) {
		x -= par1;
		y -= par2;
		return this;
	}
	
	public final IntPos subtractX(int par1) {
		return subtract(1, 0);
	}
	
	public final IntPos subtractY(int par1) {
		return subtract(0, 1);
	}
	
	public final int getX() {
		return x;
	}
	
	public final int getY() {
		return y;
	}
	
}
