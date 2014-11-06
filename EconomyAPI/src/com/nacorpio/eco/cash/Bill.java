package com.nacorpio.eco.cash;

import com.nacorpio.eco.IWalletItem;

public abstract class Bill implements IWalletItem {

	@Override
	public abstract float getValue();

}
