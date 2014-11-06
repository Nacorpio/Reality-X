package com.nacorpio.nutilities.crypt;

public class Pyramid {

	public int ncount = 0;
	
	private Node parent;
	private Node[] nodes = new Node[3];
	
	public Pyramid(byte[]... par1) {
		parent = new Node(this, new byte[] {-1});
		if (par1.length <= 3) {
			for (int i = 0; i < nodes.length; i++) {
				nodes[i] = new Node(parent, this, par1[i]);
			}
		}
	}
	
	public Node left() {
		return nodes[0];
	}
	
	public Node middle() {
		return nodes[1];
	}
	
	public Node right() {
		return nodes[2];
	}
	
	public final int totalSize() {
		return ncount;
	}
	
	public Node[] nodes() {
		return nodes;
	}
	
}
