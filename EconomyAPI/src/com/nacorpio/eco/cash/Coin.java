package com.nacorpio.eco.cash;

import com.nacorpio.eco.IWalletItem;

public abstract class Coin implements IWalletItem {

	@Override
	public abstract float getValue(); 

}
