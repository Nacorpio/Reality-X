package com.nacorpio.nutilities.collection.natural;

/**
 * Represents a leaf that can be built on a tree.<br>
 * A leaf is the only node that can store data.
 * @author Nacorpio
 */
public interface ILeaf extends INode {

	/**
	 * Returns the data of this leaf.
	 * @return the data.
	 */
	Object getData();
	
}
