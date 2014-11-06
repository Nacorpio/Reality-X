package com.nacorpio.nutilities.chemistry.environment;

public class Environment {
 
	private Temperature temperature;
	
	/**
	 * Creates a new environment with the specified temperature.
	 * @param par1 the temperature.
	 */
	public Environment(float par1) {
		this.temperature = new Temperature(par1);
	}
	
	/**
	 * Returns the current temperature of the environment.<br>
	 * The objects put in the environment will also have this temperature.
	 * @return the temperature.
	 */
	public final Temperature getTemperature() {
		return temperature;
	}
	
}
