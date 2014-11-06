package com.nacorpio.nutilities.chemistry.environment;

import com.nacorpio.nutilities.conversion.Unit;

public class Temperature {

	private float temp;
	
	public Temperature(float par1) {
		this.temp = par1;
	}
	
	public final float getKelvin() {
		return Unit.Degrees.celciusToKelvin(temp);
	}
	
	public final float getFahrenheit() {
		return Unit.Degrees.celciusToFahrenheit(temp);
	}
	
	public final float getPlanck() {
		return Unit.Degrees.celciusToPlanck(temp);
	}
	
	public final String toString() {
		return String.valueOf(temp);
	}
	
}
