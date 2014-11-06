package com.nacorpio.nutilities.chemistry.registry;

import java.util.HashMap;
import java.util.Map;

import com.nacorpio.nutilities.chemistry.element.Element;

public class ElementRegistry {

	private Map<String, Element> elements = new HashMap<String, Element>();

	public final Element getElementByName(String par1) {
		for (Element var: elements.values()) {
			if (var.getName().equalsIgnoreCase(par1))
				return var;
		}
		return null;
	}
	
	public final Element getElementByAtomicNumber(int par1) {
		for (Element var: elements.values()) {
			if (var.getAtomicNumber() == par1)
				return var;
		}
		return null;
	}
	
	public final Element getElementBySymbol(String par1) {
		for (Element var: elements.values()) {
			if (var.getSymbol().equalsIgnoreCase(par1))
				return var;
		}
		return null;
	}
	
}
