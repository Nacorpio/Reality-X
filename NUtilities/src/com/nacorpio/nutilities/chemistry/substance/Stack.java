package com.nacorpio.nutilities.chemistry.substance;

import com.nacorpio.nutilities.chemistry.element.Element;

public class Stack { 
	
	private int count;
	private Element element;
	
	public Stack(int par1, Element par2) {
		if (count >= 1 && element != null) {
			this.count = par1;
			this.element = par2;
		}
	}
	
	public final int count() {
		return count;
	}
	
	public final float getAtomicMass() {
		return count * element.getAtomicMass();
	}
	
	public final Element getElement() {
		return element;
	}
	
	public final String toString() {
		return element.getSymbol() + (count > 1 ? count : "");
	}
	
	public final boolean equals(Object par1) {
		
		if (par1 == null) {
			return false;
		}
		
		if (par1 instanceof Stack) {
			
			Stack var1 = (Stack) par1;
			return element.getSymbol() == var1.element.getSymbol() &&
				   count() == var1.count();
			
		}
		
		return par1.equals(this);
		
	}
	
}
