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
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
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
	private Account account4;
	@Autowired
	private Account account5;
	@Autowired
	private Account account6;
	@Autowired
	private Account account7;
	@Autowired
	private Account account8;
	@Autowired
	private Account account9;
	@Autowired
	private Account account10;
	@Autowired
	private Account account11;
	@Autowired
	private Account account12;
	@Autowired
	private Character character1;
	@Autowired
	private Character character2;
	@Autowired
	private Character character3;
	@Autowired
	private Character character4;
	@Autowired
	private Character character5;
	@Autowired
	private Character character6;
	@Autowired
	private Character character7;
	@Autowired
	private Character character8;
	@Autowired
	private Character character9;
	@Autowired
	private Character character10;
	@Autowired
	private Character character11;

	@Test
	public void addAccountTest(){
		accountManager.addAccount(account1);	
		assertEquals(account1,accountManager.getAccount(account1.getId()));
		accountManager.delAccount(account1);
	}

	@Test
	public void modAccountTest(){
		accountManager.addAccount(account12);
		account12.setPassword("Inne hasło");
		assertEquals(account12.getPassword(), accountManager.getAccount(account12.getId()).getPassword());
		accountManager.delAccount(account12);
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
		accountManager.addAccount(account4);
		Account accountTest = accountManager.getAccount(account4.getId());
		assertEquals(accountTest,account4);
		accountManager.delAccount(account4);
	}
	
	@Test
	public void getAccountByLogin(){
		accountManager.addAccount(account5);
		Account accountTest = accountManager.getAccount(account5.getLogin());
		assertEquals(accountTest,account5);
		accountManager.delAccount(account5);
	}
	
	@Test
	public void getAllAccounts(){
		int iloscPrzed = accountManager.getAllAccounts().size();
		accountManager.addAccount(account6);
		accountManager.addAccount(account7);
		assertEquals(iloscPrzed+2,accountManager.getAllAccounts().size());
		accountManager.delAccount(account6);
		accountManager.delAccount(account7);
	}
	
	@Test
	public void addCharacter(){
		accountManager.addAccount(account3);
		account3.getCharacters().add(character1);
		account3.getCharacters().add(character2);
		characterManager.addCharacter(character1);
		characterManager.addCharacter(character2);
		assertEquals(2,account3.getCharacters().size());
		assertNotNull(characterManager.getCharacter(character1.getIdCharacter()));
		assertNotNull(characterManager.getCharacter(character2.getIdCharacter()));
		accountManager.delAccount(account3);
	}

	@Test
	public void modCharacter(){
		characterManager.addCharacter(character11);
		character11.setCharacterRace("Inna rasa");
		assertEquals(character11.getCharacterRace(),characterManager.getCharacter(character11.getIdCharacter()).getCharacterRace());
		characterManager.delCharacter(character11);
	}
	
	@Test
	public void delCharacter(){
		accountManager.addAccount(account8);
		account8.getCharacters().add(character3);
		account8.getCharacters().add(character4);
		characterManager.addCharacter(character3);
		characterManager.addCharacter(character4);
		assertEquals(2,account8.getCharacters().size());
		assertNotNull(characterManager.getCharacter(character3.getIdCharacter()));
		assertNotNull(characterManager.getCharacter(character4.getIdCharacter()));
		account8.getCharacters().remove(character4);
		characterManager.delCharacter(character4);
		assertNotNull(characterManager.getCharacter(character3.getIdCharacter()));
		assertNull(characterManager.getCharacter(character4.getIdCharacter()));
		accountManager.delAccount(account8);
	}
	
	@Test
	public void getCharacterList(){
		accountManager.addAccount(account9);
		account9.getCharacters().add(character5);
		account9.getCharacters().add(character6);
		characterManager.addCharacter(character5);
		characterManager.addCharacter(character6);
		assertEquals(2,account9.getCharacters().size());
		accountManager.delAccount(account9);
	}
	
	@Test
	public void getCharacterByID(){
		accountManager.addAccount(account10);
		account10.getCharacters().add(character7);
		characterManager.addCharacter(character7);
		Character characterTest = characterManager.getCharacter(character7.getIdCharacter());
		assertEquals(characterTest,character7);
		accountManager.delAccount(account10);
	}
	
	@Test
	public void getCharacterByNick(){
		accountManager.addAccount(account11);
		account11.getCharacters().add(character8);
		characterManager.addCharacter(character8);
		Character characterTest = characterManager.getCharacter(character8.getNick());
		assertEquals(characterTest,character8);
		characterManager.delCharacter(character8);
		account11.getCharacters().remove(character8);
		accountManager.delAccount(account11);
	}
	
	@Test
	public void getAllCharacters(){
		int iloscPrzed = characterManager.getAllCharacters().size();
		characterManager.addCharacter(character9);
		characterManager.addCharacter(character10);
		assertEquals(iloscPrzed+2,characterManager.getAllCharacters().size());
		assertTrue(characterManager.getAllCharacters().contains(character9));
		assertTrue(characterManager.getAllCharacters().contains(character10));
		characterManager.delCharacter(character9);
		characterManager.delCharacter(character10);
	}
}
