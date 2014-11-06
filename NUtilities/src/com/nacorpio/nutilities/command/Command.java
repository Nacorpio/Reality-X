package com.nacorpio.nutilities.command;

public class Command implements ICommand {

	private String name;
	private String desc;
	
	public Command(String par1) {
		this.name = par1;
	}
	
	@Override
	public void doWork(Object... par1) {}

	/**
	 * Returns the name of the command.<br>
	 * This will be used when executing the command.
	 * @return the name.
	 */
	public final String getName() {
		return name;
	}
	
	public final Command setDescription(String par1) {
		this.desc = par1;
		return this;
	}
	
	/**
	 * Returns the description of the command.<br>
	 * This will be used when executing the <code>!help</code> command.
	 * @return the description.
	 */
	public final String getDescription() {
		return desc;
	}
	
}
