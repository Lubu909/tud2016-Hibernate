package manager;

import java.util.List;

import model.Account;

public interface IAccountManager {
	public void addAccount(Account account);
	public void delAccount(Account account);
	public Account getAccount(int id);
	public Account getAccount(String login);
	public List<Account> getAllAccounts();
}
