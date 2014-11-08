package com.nacorpio.diagnostics.log;

public class LogMessage {

	private String message;
	private Object data;
	private String[] tags;
	
	private EnumPriority priority;
	
	public LogMessage(String par1, Object par2, String[] par3, EnumPriority par4) {
		message = par1;
		data = par2;
		tags = par3;
		priority = par4;
	}

	/**
	 * Returns the message of this LogMessage.
	 * @return the message.
	 */
	public final String getMessage() {
		return message;
	}
	
	/**
	 * Returns the data of this LogMessage.
	 * @return the data.
	 */
	public final Object getData() {
		return data;
	}
	
	/**
	 * Returns the tags of this LogMessage.
	 * @return the tags.
	 */
	public final String[] getTags() {
		return tags;
	}
	
	public final EnumPriority getPriority() {
		return priority;
	}
	
	public String toString() {
		String tagStr = "";
		if (tags.length >= 1) {
			for (int i = 0; i < tags.length; i++) {
				if (i < tags.length - 1) {
					tagStr += tags[i] + ", ";
				} else {
					tagStr += tags[i];
				}
			}
		}	
		return getPriority().name + "{message:" + message + ";" + (data.toString().length() > 0 ? " data:" + data + ";" : ";") + (tagStr.length() > 0 ? " tags:[" + tagStr + "]" : "") + "}";
	}
	
}
