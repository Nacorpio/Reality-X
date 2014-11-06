package com.nacorpio.nutilities.crypt;

public class Node {
	
	private byte[] tag = new byte[4];
	private Node left, middle, right, parent;
	private Pyramid root;
	
	public Node(Pyramid par1, byte... par2) {
		this(null, par1, par2);
	}
	
	public Node(Node par1, Pyramid par2, byte[] par3) {
		if (par3.length <= 4) {
			parent = par1;
			root = par2;
			tag = par3;
			root.ncount++;
			return;
		}
		return;
	}
	
	public byte[] tag() {
		return tag;
	}
	
	public final void set(byte par1, byte[] par2) {
		if (par2.length <= 4) {
			switch (par1) {
			case 0:
				left = new Node(this, root, par2);
				break;
			case 1:
				middle = new Node(this, root, par2);
				break;
			case 2:
				right = new Node(this, root, par2);
				break;
			default:
				break;
			}
		}
	}
	
	public boolean isEmpty(byte par1) {
		switch (par1) {
		case 0:
			return left == null;
		case 1:
			return middle == null;
		case 2:
			return right == null;
		default:
			return false;
		}
	}
	
	public Node left() {
		return left;
	}
	
	public Node middle() {
		return middle;
	}
	
	public Node right() {
		return right;
	}
	
	public Node parent() {
		return parent;
	}
	
	public boolean rootParent() {
		return parent.tag()[0] == -1;
	}
	
	public final boolean equals(Object par1) {
		
		if (par1 == null) {
			return false;
		}
		
		if (par1 instanceof Node) {
			
			Node var1 = (Node) par1;
			return tag().equals(var1.tag());
			
		}
		
		return par1.equals(this);
		
	}
	
}
