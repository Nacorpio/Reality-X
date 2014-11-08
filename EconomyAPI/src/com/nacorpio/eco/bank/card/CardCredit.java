package com.nacorpio.eco.bank.card;

import java.util.ArrayList;
import java.util.List;

import com.nacorpio.eco.bank.Account;
import com.nacorpio.eco.bank.Card;
import com.nacorpio.eco.bank.Wallet;
import com.nacorpio.eco.cost.CostUtil;

public class CardCredit extends Card {

	private float monthly_deposits = 0;
	private float monthly_withdrawal = 0;

	protected float purchase_limit_m = 100000;
	protected float sending_limit_m = 10000;
	
	public CardCredit(Account par1) {
		super(par1);
	}

	@Override
	public String getName() {
		return "CreditCard";
	}

	@Override
	public float getBalance() {
		return purchase_limit_m - monthly_withdrawal;
	}

	@Override
	public void add(float par1) {
		if (monthly_deposits + par1 <= sending_limit_m) {
			monthly_deposits += par1;
		}
	}

	@Override
	public void remove(float par1) {
		if (monthly_withdrawal + par1 <= purchase_limit_m) {
			monthly_withdrawal += par1;
		}
	}

	@Override
	public boolean hasSufficientCapacity(float par1) {
		return getBalance() + par1 <= getCreditLimit();
	}

	@Override
	public boolean hasSufficientCredits(float par1) {
		return getBalance() >= par1;
	}

	@Override
	public float getCreditLimit() {
		return monthly_deposits;
	}

	@Override
	public void transfer(ICashHolder par1, float par2) {
		if (hasSufficientCredits(par2 + CostUtil.getCashHandle(par1, par2)) && par1.hasSufficientCapacity(par2)) {
			remove(par2 + CostUtil.getCashHandle(par1, par2));
			par1.add(par2);
		}
	}
	
	@Override
	public boolean withdraw(int par1, float par2, ICashHolder par3) {
		if (par1 == this.getSecurityCode()) {
			if (getBalance() - par1 >= 0) {
				float tax = CostUtil.getCashHandle(par3, par2);
				float sum = par2 + tax;
				if (hasSufficientCredits(sum) && par3.hasSufficientCapacity(sum - tax)) {
					remove(sum);
					par3.add(sum - tax);
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean deposit(int par1, float par2, ICashHolder par3) {
		if (par1 == this.getSecurityCode()) {
			onDepositAuthEvent(par3, par2);
			if (getBalance() + par1 <= getCreditLimit()) {
				float tax = CostUtil.getCashHandle(par3, par2);
				float sum = par2 + tax;
				if (par3.hasSufficientCredits(sum) && hasSufficientCapacity(sum - tax)) {
					par3.remove(sum);
					add(sum - tax);
					onDepositCompleteEvent(par3, par2);
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public void onDepositAuthEvent(ICashHolder par1, float par2) {
		
	}

	@Override
	public void onDepositCompleteEvent(ICashHolder par1, float par2) {
		
	}

	public final float getDebtsTotal() {
		return (CostUtil.getCashHandle(this, monthly_withdrawal));
	}
	
}
