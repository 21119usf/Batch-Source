package com.bankapp.utils;

import java.util.Comparator;

import com.bankapp.account.Account;

public class AccountComparator implements Comparator<Account> {
	public int compare(Account a, Account b) {
		return (int)(a.getId() - b.getId());
	}
}
