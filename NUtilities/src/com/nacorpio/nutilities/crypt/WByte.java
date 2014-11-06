package com.nacorpio.nutilities.crypt;

public class WByte {

	private byte value;
	
	public WByte(byte par1) {
		value = par1;
	}
	
	public WByte(int par1) {
		value = new Byte((byte) par1);
	}
	
	public WByte(String par1) {
		value = new Byte(par1);
	}
	
	public WByte() {
		this(0);
	}
	
	public byte set(int par1, boolean par2) {
		value = (byte) (value | ((par2 ? 1 : 0) << par1));
		return value;
	}
	
	public byte get(int par1) {
	   return (byte) (( value >> par1) & 1);
	}
	
	public byte value() {
		return value;
	}
	
	public final String toString() {
		String var1 = "";
		for (int i = 0; i < 7; i++) {var1 += get(i);} return var1;
	}
	
}
