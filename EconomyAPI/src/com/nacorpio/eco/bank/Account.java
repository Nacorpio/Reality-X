package com.nacorpio.eco.bank;

import com.nacorpio.eco.Economy;
import com.nacorpio.eco.cost.CostUtilities;

public class Account {
	
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
	
	public final boolean withdraw(Object par1, float par2, int par3) {
		if (par3 == securityCode) {
			if (balance - par2 >= 0) {
				float tax = CostUtilities.getCashHandle(null, par2);
				paid_taxes += tax;
				return true;
			}
		}
		return false;
	}
	
	public final boolean deposit(Object par1, float par2, int par3) {
		if (par3 == securityCode) {
			if (balance + par2 <= balanceLimit) {
				float tax = CostUtilities.getCashHandle(null, balance);
				paid_taxes += tax;
				balance += par2 - tax;
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
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
	
}
