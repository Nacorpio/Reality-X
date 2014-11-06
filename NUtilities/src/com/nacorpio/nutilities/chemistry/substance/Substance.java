package com.nacorpio.nutilities.chemistry.substance;

import com.nacorpio.nutilities.chemistry.environment.IHeatable;

public class Substance implements IHeatable {

	private float size;
	private float temp;
	
	private Stack[] stacks;
	
	public Substance(float par1, Stack... par2) {
		this.size = par1;
		this.stacks = par2;
	}
	
	public final Stack[] getStacks() {
		return stacks;
	}

	public float getSize() {
		return size;
	}
	
	@Override
	public float getTemperature() {
		return temp;
	}

	@Override
	public void setTemperature(float par1) {
		this.temp = par1;
	}
	
	public final String toString() {
		String var1 = "";
		for (Stack var: stacks) {
			var1 += var;
		}
		return var1;
	}
	
}
