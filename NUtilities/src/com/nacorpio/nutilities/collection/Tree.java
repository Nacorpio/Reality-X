package com.nacorpio.nutilities.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents a tree that stores nodes that will store data.
 * @author Nacorpio
 */
public class Tree implements IParental {

	public static class ObjectNode extends Node<Object> {

		public ObjectNode(String par1, Object par2) {
			super(par1, par2);
		}
		
	}
	
	public static class ModifiableNode<T> extends Node<T> implements IModifiable<T> {

		public ModifiableNode(String par1, T par2) {
			super(par1, par2);
		}
		
		@Override
		public Node<T> setData(T par1) {
			this.data = par1;
			return this;
		}
		
	}
	
	/**
	 * Represents a node which holds data and an identifier.
	 * @author Nacorpio
	 * @param <T> the type of data.
	 */
	public static class Node<T> implements IParental {
		
		String name;
		
		IParental parent;
		Tree root;
		
		int index;
		
		T data = null;
		
		List<Node<T>> children = new ArrayList<Node<T>>();
		
		public Node(String par1, T par2) {
			name = par1;
			data = par2;
		}
	
		public Node(String par1) {
			name = par1;
		}
		
		/**
		 * Returns the name of the node.
		 * @return the name.
		 */
		public String getName() {
			return this.name;
		}
		
		/**
		 * Returns the data of the node.
		 * @return the data,
		 */
		public T getData() {
			return this.data;
		}
		
		private final void setParent(IParental par1) {
			this.parent = par1;
		}
		
		/**
		 * Returns the node that keeps this node as a child.
		 * @return the parent.
		 */
		public IParental getParent() {
			return this.parent;
		}
		
		@SuppressWarnings("unchecked")
		public final Node<T> add(IParental par1) {
			
			Node<T> var1 = (Node<T>) par1;
			
			var1.setIndex(children.size());
			var1.setParent(this);
			var1.root = this.root;
			
			putTree(var1.getId(), var1);
			
			this.children.add(var1);
			return var1;
			
		}
		
		public final Node<T> add(String par1) {
			return add(par1, null);
		}
		
		public final Node<T> add(String par1, Object par2) {
			return add(new ObjectNode(par1, par2));
		}
		
		public final void remove(String par1) {
			children.remove(get(par1));
		}
		
		public final Node<T> get(String par1) {
			for (Node<T> var: children) {
				if (var.getName().equals(par1))
					return var;
			}
			return null;
		}
		
		public final void setIndex(int par1) {
			this.index = par1;
		}
		
		public final int getIndex() {
			return this.index;
		}
		
		public final Tree getRoot() {
			return this.root;
		}
		
		/**
		 * Returns the children of the node.
		 * @return the children.
		 */
		public List<Node<T>> getChildren() {
			return this.children;
		}

		@Override
		public boolean isParent() {
			return children.size() > 0;
		}

		@Override
		public String getId() {
			return getIndex() + ":" + getParent().getId();
		}

	}
	
	private static Map<String, Node<?>> tree = new HashMap<String, Node<?>>();
	private List<Node<?>> nodes = new ArrayList<Node<?>>();
	
	public Tree() {
		nodes.clear();
	}
	
	public final Node<?> add(IParental par1) {
		
		if (!(par1 instanceof Node<?>)) {
			return null;
		}
		
		Node<?> var1 = (Node<?>) par1;
		
		var1.root = this;
		var1.setParent(this);
		var1.setIndex(nodes.size());
		
		putTree(var1.getId(), var1);
		
		nodes.add(var1);
		return var1;
		
	}

	private static final void putTree(String par1, Node<?> par2) {
		tree.put(par1, par2);
	}
	
	/**
	 * Adds a node with the specified name and value.
	 * @param par1 the name.
	 * @param par2 the value.
	 * @return the node.
	 */
	public final Node<?> add(String par1, Object par2) {
		return add(new ObjectNode(par1, par2));
	}
	
	/**
	 * Removes the node with the specified name.
	 * @param par1 the name.
	 */
	public final void remove(String par1) {
		nodes.remove(get(par1));
	}
	
	/**
	 * Returns the node with the specified name.
	 * @param par1 the name.
	 * @return the node.
	 */
	public final Node<?> get(String par1) {
		for (Node<?> var: nodes) {
			if (var.getName().equals(par1))
				return var;
		}
		return null;
	}
	
	/**
	 * Returns the first node in the tree.
	 * @return the first node.
	 */
	public final Node<?> getFirstNode() {
		return nodes.get(0);
	}
	
	/**
	 * Returns the last node in the tree.
	 * @return the last node.
	 */
	public final Node<?> getLastNode() {
		return nodes.get((nodes.size() > 1 ? nodes.size() - 1 : 0));
	}
	
	/**
	 * Returns the amount of children nodes within this tree.
	 * @return the amount of nodes.
	 */
	public final int size() {
		return nodes.size();
	}
	
	/**
	 * Returns the amount of children nodes within the whole tree.
	 * @return the total amount of nodes.
	 */
	public final int totalSize() {
		return tree.size();
	}
	
	/**
	 * Find a node with the specified id.<br>
	 * The node must be existant in the tree.
	 * @param par1 the id.
	 * @return the node.
	 */
	public final Node<?> findId(String par1) {
		return tree.get(par1);
	}
	
	/**
	 * Returns whether a node with the specified id exists.
	 * @param par1 the id.
	 * @return true/false.
	 */
	public final boolean hasId(String par1) {
		return tree.containsKey(par1);
	}
	
	/**
	 * Find a node with the specified coordinates.
	 * @param par1 the integers representing the coordinates of a node.
	 * @return the node.
	 */
	public final Node<?> findId(int... par1) {
		String var1 = "";
		for (int i = 0; i < par1.length; i++) {
			if (i < par1.length - 1) {
				var1 += par1[i] + ":";
			} else {
				var1 += par1[i];
			}
		}
		return findId(var1);
	}
	
	@Override
	public boolean isParent() {
		return true;
	}


	@Override
	public String getId() {
		return String.valueOf(0);
	}

	public final String toString() {
		
		String var1 = "";
		
		var1 += Builder.declareRoot() + "\n";
		for (Node<?> var: this.nodes) {
			var1 += Builder.insertNode(var.getId(), "@NODE", new String[] {"name=" + var.getName(), "data=" + var.getData()}, false) + "\n";
		}
		
		/*for (Node<?> var: this.tree.values()) {
			var1 += Builder.insertNode(var.getId(), "@NODE", new String[] {"name=" + var.getName(), "data=" + var.getData()}, false) + "\n";
		}*/
		
		return var1;
		
	}
	
}
