package com.revature.beans;

import java.io.Serializable;
import java.util.ArrayList;

import com.reavature.service.AccountsService;
import com.reavature.service.ValidationException;

public class Account implements Serializable {

	private static final long serialVersionUID = -5730575491757304654L;
	private int id;
	private ArrayList<Integer> owners;
	private double balance;
	private AccountStatus status;
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", owners=" + owners + ", balance=" + balance + ", status=" + status + "]";
	}
	public void setId(int id) {
		this.id = id;
	}
	public ArrayList<Integer> getOwners() {
		return owners;
	}
	public void setOwners(ArrayList<Integer> owners) {
		this.owners = owners;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Account(int id, ArrayList<Integer> owners, double balance) {
		super();
		this.id = id;
		this.owners = owners;
		this.balance = balance;
		this.setStatus(AccountStatus.pending);
	}
	
	public Account() {}
	public AccountStatus getStatus() {
		return status;
	}
	public void setStatus(AccountStatus status) {
		this.status = status;
	}
	
//	public void transferTo(Account a, double ammount) {
//		this.balance -= ammount;
//		a.balance += ammount;
//		AccountsService.updateAccount(this);
//		AccountsService.updateAccount(a);
//	}
	
	public void transferTo(int accountId, double ammount) throws ValidationException {
		if (ammount < 0) {
			throw new ValidationException("Ammount must be more then 0");
		}
		if (ammount > this.balance) {
			throw new ValidationException("You do not have that much money to withdraw");
		}
		Account a = AccountsService.getAccountById(accountId);
		this.balance -= ammount;
		a.setBalance(a.getBalance() + ammount);
		AccountsService.updateAccount(this);
		AccountsService.updateAccount(a);
	}
	
//	public void TransferFrom(Account a, double ammount) {
//		this.balance += ammount;
//		a.balance -= ammount;
//		AccountsService.updateAccount(a);
//		AccountsService.updateAccount(this);
//	}
	
	public void transferFrom(int accountId, double ammount) throws ValidationException {
		Account a = AccountsService.getAccountById(accountId);
		if (ammount < 0) {
			throw new ValidationException("Ammount must be more then 0");
		}
		if (a.getBalance() < ammount) {
			throw new ValidationException("Account does not have that much money to withdraw");
		}
		a.setBalance(a.getBalance() - ammount);
		this.balance += ammount;
		AccountsService.updateAccount(a);
		AccountsService.updateAccount(this);
	}
}
