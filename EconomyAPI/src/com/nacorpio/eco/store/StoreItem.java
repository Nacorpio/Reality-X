package com.nacorpio.eco.store;

public class StoreItem {

	private Commodity com;
	private String identifier;
	
	private int quantity;
	
	public StoreItem(Commodity par1, String par2, int par3) {
		com = par1;
		identifier = par2;
		quantity = par3;
	}

	public final Commodity getCommodity() {
		return com;
	}
	
	public final String getId() {
		return identifier;
	}
	
	public final int getQuantity() {
		return quantity;
	}
	
}
