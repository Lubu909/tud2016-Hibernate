package com.tud2016Hibernate.manager;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.tud2016Hibernate.manager.AccountManager;
import com.tud2016Hibernate.manager.CharacterManager;
import com.tud2016Hibernate.model.Account;
import com.tud2016Hibernate.model.Character;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
@Transactional
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = false)
public class SpringHibernateTest {
	
	@Autowired
	AccountManager accountManager;
	
	@Autowired
	CharacterManager characterManager;

	@Autowired
	private Account account1;
	@Autowired
	private Account account2;
	@Autowired
	private Account account3;
	@Autowired
	private Character character1;
	@Autowired
	private Character character2;
	@Autowired
	private Character character3;
	@Autowired
	private Character character4;
	
	@Test
	public void addAccountTest(){ 
		//account1.setId(null);
		accountManager.addAccount(account1);	
		assertEquals(account1,accountManager.getAccount(account1.getId()));
	}

	@Test
	public void delAccountTest(){
		int iloscPrzed = accountManager.getAllAccounts().size();
		accountManager.addAccount(account2);
		assertEquals(iloscPrzed+1,accountManager.getAllAccounts().size());
		accountManager.delAccount(account2);
		assertEquals(iloscPrzed,accountManager.getAllAccounts().size());
		assertNull(accountManager.getAccount(account2.getId()));
	}
	
	@Test
	public void getAccountByID(){
		fail("Not yet implemented!");
	}
	
	@Test
	public void getAccountByLogin(){
		fail("Not yet implemented!");
	}
	
	@Test
	public void getAllAccounts(){
		fail("Not yet implemented!");
	}
	
	@Test
	public void addCharacter(){
		accountManager.addAccount(account3);
		account3.getCharacters().add(character3);
		account3.getCharacters().add(character4);
		characterManager.addCharacter(character3);
		characterManager.addCharacter(character4);
		assertEquals(2,account3.getCharacters().size());
		assertNotNull(characterManager.getCharacter(character3.getIdCharacter()));
		assertNotNull(characterManager.getCharacter(character4.getIdCharacter()));
	}
	
	@Test
	public void delCharacter(){
		fail("Not yet implemented!");
	}
	
	@Test
	public void getCharacterList(){
		fail("Not yet implemented!");
	}
	
	@Test
	public void getCharacterByID(){
		fail("Not yet implemented!");
	}
	
	@Test
	public void getCharacterByNick(){
		fail("Not yet implemented!");
	}
	
	@Test
	public void getAllCharacters(){
		fail("Not yet implemented!");
	}
}
