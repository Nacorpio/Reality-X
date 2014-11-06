package com.nacorpio.nutilities.chemistry.compound;

import com.nacorpio.nutilities.chemistry.element.Element;
import com.nacorpio.nutilities.object.util.ObjectUtils;

public class Compound {

	private String name;
	private Element[] elements;
	
	public Compound(String par1, Element... par2) {
		this.name = par1;
		this.elements = par2;
	}
	
	public final String getName() {
		return name;
	}
	
	/**
	 * Returns the atomic weight of the compound.
	 * @return the atomic weight.
	 */
	public final float getMolarMass() {
		float var1 = 0;
		for (Element var: elements) {
			var1 += var.getAtomicMass();
		}
		return var1;
	}
	
	/**
	 * Returns the elements of the compound.
	 * @return the elements.
	 */
	public final Element[] getElements() {
		return elements;
	}
	
	public final boolean equals(Object par1) {
		
		if (par1 == null) {
			return false;
		}
		
		if (par1 instanceof Compound) {
			
			Compound var1 = (Compound) par1;
			return ObjectUtils.equals(elements, var1.elements);
			
		}
		
		return par1.equals(this);
		
	}
	
}
