package com.nacorpio.nutilities.collection.natural;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NaturalTree implements IRoot {
	
	private Map<String, INode> structure = new HashMap<String, INode>(); 
	private List<INode> nodes = new ArrayList<INode>();
	
	@Override
	public INode add(INode par1) {
		nodes.add(par1);
		return par1;
	}
	
	@Override
	public void remove(String par1) {
		nodes.remove(get(par1));
	}

	@Override
	public int size() {
		return nodes.size();
	}

	@Override
	public int totalSize() {
		return 0;
	}

	@Override
	public int branchCount() {
		return 0;
	}

	@Override
	public int leafCount() {
		return 0;
	}

	@Override
	public INode get(String par1) {
		for (INode var: nodes) {
			if (var.getName().equals(par1)) 
				return var;
		}
		return null;
	}

	@Override
	public void onNodeAdded(INode par1, int par2) {
		structure.put(par1.getId(), par1);
	}

	@Override
	public INode add(String par1, Object par2, byte par3) {
		Leaf var1 = new Leaf(par1, this, par2);
		nodes.add(var1);
		return var1;
	}

	@Override
	public INode add(String par1, byte par2) {
		return null; 
	}

}
