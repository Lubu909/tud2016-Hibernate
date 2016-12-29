package com.tud2016Hibernate.manager;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.tud2016Hibernate.model.Account;

@Component
@Transactional
public class AccountManagerHibernateImpl implements AccountManager {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addAccount(Account account) {
		this.sessionFactory.getCurrentSession().persist(account);
	}

	@Override
	public void delAccount(Account account) {
		account = (Account) this.sessionFactory.getCurrentSession().get(Account.class, account.getId());
		this.sessionFactory.getCurrentSession().delete(account);
	}

	@Override
	public Account getAccount(int id) {
		return (Account) this.sessionFactory.getCurrentSession().get(Account.class, id);
	}

	@Override
	public Account getAccount(String login) {
		return (Account) this.sessionFactory.getCurrentSession().getNamedQuery("account.byLogin").setString("login", login).uniqueResult();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Account> getAllAccounts() {
		return this.sessionFactory.getCurrentSession().getNamedQuery("account.all").list();
	}

}
