package com.nacorpio.diagnostics;

import com.nacorpio.diagnostics.log.EnumPriority;
import com.nacorpio.diagnostics.log.LogMessage;

public final class Logging {

	/**
	 * Logs a message with the specified parameters.
	 * @param par1 the message of the log.
	 * @param par2 the data of the log.
	 * @param par3 the tags of the log.
	 * @param par4 the priority of the log.
	 */
	public static final void log(String par1, Object par2, String[] par3, EnumPriority par4) {
		System.out.println(new LogMessage(par1, par2, par3, par4));
	}
	
	/**
	 * Logs a message with the specified parameters.
	 * @param par1 the message of the log.
	 * @param par2 the data of the log.
	 * @param par3 the tags of the log.
	 */
	public static final void log(String par1, Object par2, String... par3) {
		log(par1, par2, par3, EnumPriority.MESSAGE);
	}
	
	/**
	 * Logs a message with the specified {@code message} and {@code data}.
	 * @param par1 the message of the log.
	 * @param par2 the data of the log.
	 */
	public static final void log(String par1, Object par2) {
		log(par1, par2);
	}
	 
	/**
	 * Logs a message with the specified message.
	 * @param par1 the message of the log.
	 */
	public static final void log(String par1) {
		log(par1, "");
	}
	
}
