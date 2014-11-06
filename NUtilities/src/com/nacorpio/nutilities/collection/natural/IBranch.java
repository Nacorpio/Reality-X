package com.nacorpio.nutilities.collection.natural;

/**
 * Represents a branch that can be built on a tree.<br>
 * A branch is the only node that can store children.
 * @author Nacorpio
 */
public interface IBranch extends INode, IParental {
	
	/**
	 * Returns the tag of the branch.<br>
	 * This is used to store additional data.
	 * @return the tag.
	 */
	byte tag();
	
	/**
	 * Occurs when a node has been added to this branch.
	 * @param par1 the node.
	 * @param par2 the index of where the node was added.
	 */
	void onNodeAdded(INode par1, int par2);
	
}