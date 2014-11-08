package com.nacorpio.eco.bank;

import com.nacorpio.eco.Economy;
import com.nacorpio.eco.bank.card.ICashHolder;
import com.nacorpio.eco.cost.CostUtil;

public class Account implements ICashHolder {
	
	private String holderFName, holderLName;
	private String billingAddress, billingAddress2;
	private String socialSecurityNumber;
	
	protected int securityCode = 9999;

	private float balance;
	protected float balanceLimit = 75000;
	
	protected float paid_taxes = 0;
	
	public Account(String par1, String par2, String par3, String par4) {
		holderFName = par1;
		holderLName = par2;
		socialSecurityNumber = par3;
		billingAddress = par4;
	}
	
	@Override
	public void transfer(ICashHolder par1, float par2) {
		if (hasSufficientCredits(par2 + CostUtil.getCashHandle(par1, par2)) && par1.hasSufficientCapacity(par2)) {
			remove(par2 + CostUtil.getCashHandle(par1, par2));
			par1.add(par2);
		}
	}
	
	public final boolean withdraw(ICashHolder par1, float par2, int par3) {
		if (par3 == securityCode) {
			if (balance - par2 >= 0) {
				float tax = CostUtil.getCashHandle(par1, par2);
				float sum = par2 + tax;
				if (par1.hasSufficientCapacity(sum - tax) && hasSufficientCredits(sum)) {
					remove(sum);
					par1.add(sum - tax);
					return true;
				}				
			}
		}
		return false;
	}
	
	public final boolean deposit(ICashHolder par1, float par2, int par3) {
		if (par3 == securityCode) {
			if (balance + par2 <= balanceLimit) {
				float tax = CostUtil.getCashHandle(par1, par2);
				float sum = par2 + tax;
				if (hasSufficientCapacity(sum) && par1.hasSufficientCredits(sum)) {
					par1.remove(sum);
					add(sum - tax);
					return true;
				}
			}
		}
		return false;
	}
	
	public final String getHFirstName() {
		return holderFName;
	}

	public final String getHLastName() {
		return holderLName;
	}
	
	public final String getHBillingAddress() {
		return billingAddress;
	}
	
	public final String getHSSN() {
		return socialSecurityNumber;
	}

	@Override
	public float getBalance() {
		return balance;
	}

	@Override
	public void add(float par1) {
		if (balance + par1 <= balanceLimit) {
			balance += par1;
		}
	}

	@Override
	public void remove(float par1) {
		if (balance - par1 >= 0) {
			balance -= par1;
		}
	}

	@Override
	public boolean hasSufficientCapacity(float par1) {
		return (getBalance() + par1 <= getCreditLimit() && getBalance() + par1 >= 0);
	}

	@Override
	public float getCreditLimit() {
		return balanceLimit;
	}

	@Override
	public boolean hasSufficientCredits(float par1) {
		return getBalance() >= par1;
	}
	
}
