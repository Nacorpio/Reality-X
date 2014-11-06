package com.nacorpio.traffic;


public class SubBlock {

	private String name;
	private float size;
	private Block parent;
	
	protected SubBlock(String par1, float par2, Block par3) {
		name = par1;
		size = par2;
		parent = par3;
	}
	
	public final String getName() {
		return name;
	}
	
	public final float getSize() {
		return size;
	}
	
	public final Block getParent() {
		return parent;
	}
	
}
