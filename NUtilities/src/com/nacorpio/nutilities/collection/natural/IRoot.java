package com.nacorpio.nutilities.collection.natural;

public interface IRoot extends IParental {

	/**
	 * Returns the amount of branches this root has.
	 * @return the amount of branches.
	 */
	int branchCount();
	
	/**
	 * Returns the amount of leaves this root has.
	 * @return the amount of leaves.
	 */
	int leafCount();
	
	/**
	 * Occurs when a node has been added to this root.
	 * @param par1 the node.
	 * @param par2 the index of where the node was added.
	 */
	void onNodeAdded(INode par1, int par2);
	
}
