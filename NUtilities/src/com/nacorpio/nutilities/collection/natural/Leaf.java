package com.nacorpio.nutilities.collection.natural;

public class Leaf implements ILeaf {

	private String name;
	private IParental parent;
	
	private Object data;
	
	/**
	 * Creates a new leaf.
	 * @param par1 the name.
	 * @param par2 the parent.
	 * @param par3 the data.
	 */
	public Leaf(String par1, IParental par2, Object par3) {
		this.name = par1;
		this.parent = par2;
		this.data = par3;
	}
	
	/**
	 * Creates a new leaf.
	 * @param par1 the name.
	 * @param par2 the parent.
	 */
	public Leaf(String par1, IParental par2) {
		this(par1, par2, null);
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getId() {
		if (parent instanceof IRoot && parent instanceof NaturalTree) {
			return getIndex() + ":" + 0;
		} else if (parent instanceof IBranch) {
			return getIndex() + ":" + ((IBranch) parent).getId();
		}
		return null;
	}
	
	@Override
	public int getIndex() {
		return 0;
	}

	@Override
	public IParental getParent() {
		return parent;
	}

	@Override
	public Object getData() {
		return data;
	}

	public final boolean equals(Object par1) {
		
		if (par1.equals(null)) {
			return false;
		}
		
		if (par1 instanceof ILeaf) {
			
			Leaf var1 = (Leaf) par1;
			return name.equals(var1.getName()) &&
				   parent.equals(var1.parent) &&
				   data.equals(var1.data);
			
		}
		
		return par1.equals(this);
		
	}
	
	public final Leaf clone() {
		return new Leaf(name, parent, data);
	}
	
}
