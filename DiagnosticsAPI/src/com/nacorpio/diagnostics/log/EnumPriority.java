package com.nacorpio.diagnostics.log;

public enum EnumPriority {

	MESSAGE("Message", 6),
	INFORMATION("Information", 5),
	WARNING("Warning", 4),
	ERROR("Error", 3),
	CRITICAL("Critical", 2),
	FATAL("Fatal", 1);
	
	public String name;
	public int priority;
	
	EnumPriority(String par1, int par2) {
		name = par1;
	}
	
}
