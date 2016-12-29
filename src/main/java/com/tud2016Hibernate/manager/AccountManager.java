package com.tud2016Hibernate.manager;

import java.util.List;

import com.tud2016Hibernate.model.Account;

public interface AccountManager {
	public void addAccount(Account account);
	public void delAccount(Account account);
	public Account getAccount(int id);
	public Account getAccount(String login);
	public List<Account> getAllAccounts();
}
