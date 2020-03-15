package model.entities;

import model.exceptions.IllegalWithdrawException;

public class Account {
	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	public Integer getNumber() {
		return number;
	}
	public Account(Integer number, String holder, Double balance, Double withdrawLimit) throws IllegalWithdrawException{
		if(number < 0) {
			throw new IllegalArgumentException("Error, the number of account must be positive.");
		}
		this.number = number;
		this.holder = holder;
		if(balance < 0) {
			throw new IllegalArgumentException("Error, the balance must be positive.");
		}
		this.balance = balance;
		if(withdrawLimit < 0) {
			throw new IllegalArgumentException("Error, the withdraw limit of account must be positive.");
		}
		this.withdrawLimit = withdrawLimit;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getHolder() {
		return holder;
	}
	public void setHolder(String holder) {
		this.holder = holder;
	}
	public Double getWithdrawLimit() {
		return withdrawLimit;
	}
	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}
	public Double getBalance() {
		return balance;
	}
	
	
	public void deposit(double value) {
		this.balance = value;
	}
	
	public void withdraw(double value)  throws IllegalWithdrawException{
		if(this.balance < value) {
			throw new IllegalWithdrawException("Error! The balance is insuficent.");
		}else if(this.withdrawLimit < value) {
			throw new IllegalWithdrawException("The amount exceeds withdraw limit.");
		}else {
			this.balance -= value;
		}
	}
}
