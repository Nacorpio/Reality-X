package com.nacorpio.nutilities.collection.natural;

public interface IParental {

	/**
	 * Adds a node to the root.
	 * @param par1 the node.
	 */
	INode add(INode par1);
	
	INode add(String par1, Object par2, byte par3);
	
	INode add(String par1, byte par3);
	
	INode get(String par1);
	
	/**
	 * Removes the node with the specified name.
	 * @param par1 the name.
	 */
	void remove(String par1);
	
	/**
	 * Returns the amount of children grows off this root.
	 * @return the amount of children.
	 */
	int size();
	
	/**
	 * Returns the total amount of nodes that grows of this root.
	 * @return the total amount of nodes.
	 */
	int totalSize();
	
}
