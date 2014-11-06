package com.nacorpio.nutilities.collection;

public final class Builder {

	/**
	 * Returns a command which tells the builder to declare a node.<br>
	 * @return the command.
	 */
	public static final String declare(String par1) {
		return "[" + par1 + "]";
	}

	public static final boolean isDeclareCommand(String par1, String par2) {
		return par1.matches("\\[" + par2 + "\\]");
	}
	
	public static final String getDeclareName(String par1) {
		return par1.split("\\[")[1].split("\\]")[0];
	}
	
	/**
	 * Returns a command which tells the builder to declare a root.<br>
	 * Using this more than once will reset the root to its default state.
	 * @return the command.
	 */
	public static final String declareRoot() {
		return declare("@ROOT");
	}
	
	/**
	 * Returns a command which tells the builder to insert a node at the specified coordinates.<br>
	 * If you want to insert a node at the root, just type <code>@ROOT</code> in the first parameter.<br>
	 * There is only one type available, which is called <code>@NODE</code>.
	 * @param par1 the coordinates to insert the node to.
	 * @param par2 the type of node to insert.
	 * @param par3 the properties of the node.
	 * @param par4 whether the m flag is enabled.
	 * @return the command.
	 */
	public static final String insertNode(String par1, String par2, String[] par3, boolean par4) {
		String var1 = "";
		for (int i = 0; i < par3.length; i++) {
			if (i < par3.length - 1) {
				var1 += par3[i] + "&";
			} else {
				var1 += par3[i];
			}
		}
		return "[" + par1 + "]<-[" + par2 + (par4 ? ":m" : "") + "{" + var1 + "}]";
	}
	
	/**
	 * Returns whether the specified String is a valid INSERT command,
	 * @param par1 the command.
	 * @return true/false.
	 */
	public static final boolean isInsertCommand(String par1) {
		return par1.trim().matches("\\[.*?]<-\\[@NODE(:.*)?(\\{.*?\\})?\\]");
	}
	
	/**
	 * Returns which coordinate the command is pointing to.
	 * @param par1 the command.
	 * @return the coordinate.
	 */
	public static final String getPointingTo(String par1) {
		return par1.split("<-")[0].split("\\[")[1].split("\\]")[0];
	}
	
	/**
	 * Returns which coordinate is pointing in the command.
	 * @param par1 the command.
	 * @return the pointing coordinate.
	 */
	public static final String getPointingFrom(String par1) {
		return par1.split("<-")[1].split("\\[")[1].split("\\]")[0];
	}
	
	/**
	 * Returns the properties within the specified command.
	 * @param par1 the command.
	 * @return the properties.
	 */
	public static final String[] getProperties(String par1) {
		String var1 = getPointingFrom(par1).trim().split("\\{")[1].split("\\}")[0];
		if (var1.contains("&")) {
			return var1.split("&");
		} else {
			return new String[] {var1};
		}
	}
	
	/**
	 * Returns whether the specified command has a flag.
	 * @param par1 the command.
	 * @param par2 the flag.
	 * @return true/false.
	 */
	public static final boolean hasFlag(String par1, char par2) {
		return getPointingFrom(par1).matches("\\[@NODE:" + par2 + "(\\{.*?\\})?\\]");
	}
	
}
