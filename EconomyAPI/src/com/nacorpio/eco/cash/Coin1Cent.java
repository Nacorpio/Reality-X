package com.nacorpio.eco.cash;

public class Coin1Cent extends Coin {

	@Override
	public float getValue() {
		return 0.01F;
	}

	@Override
	public String getName() {
		return "1¢";
	}

}
