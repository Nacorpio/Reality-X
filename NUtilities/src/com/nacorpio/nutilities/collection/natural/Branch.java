package com.nacorpio.nutilities.collection.natural;

import java.util.ArrayList;
import java.util.List;

public class Branch implements IBranch {

	private String name;
	private IParental parent;
	private byte tag;
	
	private List<INode> nodes = new ArrayList<INode>();
	
	public Branch(String par1, IParental par2, byte par3) {
		this.name = par1;
		this.parent = par2;
		this.tag = par3;
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
	public INode add(INode par1) {
		nodes.add(par1);
		return par1;
	}

	@Override
	public INode add(String par1, Object par2, byte par3) {
		switch (par3) {
		case 0:
			return new Leaf(par1, this, par2);
		case 1:
			return new Branch(par1, this, (byte) par2);
		default:
			return null;
		}
	}

	@Override
	public INode add(String par1, byte par3) {
		return add(par1, null, par3);
	}

	@Override
	public INode get(String par1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(String par1) {
		// TODO Auto-generated method stub

	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int totalSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public byte tag() {
		return tag;
	}

	@Override
	public void onNodeAdded(INode par1, int par2) {
		// TODO Auto-generated method stub

	}

}
