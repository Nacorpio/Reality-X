package com.nacorpio.nutilities.crypt;

import java.nio.charset.Charset;

public class WByteArray {

	private WByte[] value = new WByte[] {};
	
	public WByteArray(byte... par1) {
		System.out.println(par1.length);
		for (int i = 0; i < par1.length; i++) {
			if (par1[i] != 0)
				value[i] = new WByte(par1[i]);
		}
	}
	
	public WByteArray(String par1, String par2) {
		this(par1.getBytes(Charset.forName(par2)));
	}
	
	public WByteArray(String par1) {
		this(par1, "UTF-8");
	}
	
	public WByte[] value() {
		return value;
	}
	
	public final String toString() {
		String var1 = "{";
		for (int i = 0; i < value.length; i++) {
			if (!(value[i] == null)) {
				if (i < value.length - 1) {
					var1 += "" + value[i] + ", ";
				} else {
					var1 += "" + value[i] + "";
				}
			}	
		}
		return var1 + "}";
	}
	
}
