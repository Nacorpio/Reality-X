package com.nacorpio.nutilities.collection.natural;

public interface INode {

	/**
	 * Returns the name of this node.
	 * @return the name.
	 */
	String getName();

	/**
	 * Returns the unique id of this node.
	 * @return the id.
	 */
	String getId();
	
	/**
	 * Returns the index of this node in the tree.
	 * @return the index.
	 */
	int getIndex();
	
	/**
	 * Returns the parental object for this node.
	 * @return the parent.
	 */
	IParental getParent();
	
}
