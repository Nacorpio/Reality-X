package com.nacorpio.eco.bank.card;

import com.nacorpio.eco.bank.Account;
import com.nacorpio.eco.bank.Card;
import com.nacorpio.eco.cost.CostUtil;

public final class CardDebit extends Card {

	private float balance;
	
	public CardDebit(Account par1) {
		super(par1);
		balance = par1.getBalance();
	}

	@Override
	public String getName() {
		return "DebitCard";
	}

	@Override
	public float getBalance() {
		return balance;
	}

	@Override
	public void add(float par1) {
		if (getBalance() + par1 <= getCreditLimit()) {
			balance += par1;
		}
	}

	@Override
	public void remove(float par1) {
		if (getBalance() - par1 >= 0) {
			balance -= par1;
		}
	}

	@Override
	public boolean hasSufficientCapacity(float par1) {
		return (getCreditLimit() - getBalance()) <= par1;
	}

	@Override
	public boolean hasSufficientCredits(float par1) {
		return getBalance() >= par1;
	}

	@Override
	public float getCreditLimit() {
		return 20000;
	}

	@Override
	public boolean withdraw(int par1, float par2, ICashHolder par3) {
		
		if (hasSufficientCredits(-par2) && par3.hasSufficientCapacity(par2)) {
			
			float tax = CostUtil.getCashHandle(par3, par2);
			float sum = par2 + tax;
			
			remove(sum);
			par3.add(sum - tax);
			
			return true;
			
		}
		
		return false;
		
	}

	@Override
	public boolean deposit(int par1, float par2, ICashHolder par3) {

		if (par3.hasSufficientCredits(-par2) && hasSufficientCapacity(par2)) {
			
			float tax = CostUtil.getCashHandle(par3, par2);
			float sum = par2 + tax;
			
			par3.remove(sum);
			add(sum - tax);
			
			return true;
			
		}
		
		return false;
		
	}

	@Override
	public void onDepositAuthEvent(ICashHolder par1, float par2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDepositCompleteEvent(ICashHolder par1, float par2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transfer(ICashHolder par1, float par2) {
		// TODO Auto-generated method stub
		
	}

}
