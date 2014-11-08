package com.nacorpio.diagnostics;

import com.nacorpio.diagnostics.log.EnumPriority;
import com.nacorpio.diagnostics.log.LogMessage;

public final class Logging {

	public static final void log(String par1, Object par2, String[] par3, EnumPriority par4) {
		System.out.println(new LogMessage(par1, par2, par3, par4));
	}
	
	public static final void log(String par1, Object par2, String... par3) {
		log(par1, par2, par3, EnumPriority.MESSAGE);
	}
	
	public static final void log(String par1, Object par2) {
		log(par1, par2);
	}
	 
	public static final void log(String par1) {
		log(par1, "");
	}
	
}
