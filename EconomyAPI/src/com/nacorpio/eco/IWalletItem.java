package com.nacorpio.eco;

public interface IWalletItem {

	/**
	 * Returns the name of the item.
	 * @return the name.
	 */
	String getName();
	
	/**
	 * Returns the value of this item.
	 * @return
	 * <p>
	 * <div>
	 * <b>-1</b> if there's no value to the item.
	 * </div>
	 */
	float getValue();
	
}
