package com.nacorpio.nutilities.command;

public class CommandHelp extends Command implements ICommand {

	public CommandHelp() {
		super("help");
	}

	@Override
	public final void doWork(Object... par1) {
		System.out.println("<Available Commands>\n"
						+ "\t- !help");
	}
	
}
