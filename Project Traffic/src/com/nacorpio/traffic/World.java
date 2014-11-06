package com.nacorpio.traffic;


public class World {

	public static final Block[][] blocks = new Block[32][32];
	
	public final void set(int par1, int par2, Block par3) {
		blocks[par1][par2] = par3;
	}
	
	public final Block get(int par1, int par2) {
		return blocks[par1][par2];
	}
	
	public final void reinit() {
		for (int x = 0; x < 32; x++) {
			for (int y = 0; y < 32; y++) {
				blocks[x][y] = null;
			}
		}
	}
	
}
