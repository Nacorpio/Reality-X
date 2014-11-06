package com.nacorpio.nutilities.command;

public interface ICommand {

	/**
	 * Do work with the specified parameters.
	 * @param par1 the parameters.
	 */
	void doWork(Object... par1);
	
}
