package com.tud2016Hibernate.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.tud2016Hibernate.model.Character;

@Entity
@NamedQueries({
	@NamedQuery(name = "account.all", query = "SELECT a FROM Account a"),
	@NamedQuery(name = "account.byLogin", query = "SELECT a FROM Account a WHERE a.login = :login")
})
public class Account {
	private int id;
	@Column(unique = true)
	private String login;
	private String password;
	private String registrationDate;
	private String lastLoginDate;
	
	private List<Character> characters = new ArrayList<Character>();
	
	public Account(){
	}
	
	public Account(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}

	public Account(int id, String login, String password, String registrationDate, String lastLoginDate) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.registrationDate = registrationDate;
		this.lastLoginDate = lastLoginDate;
	}
	
	public Account(String login, String password, String registrationDate, String lastLoginDate) {
		super();
		this.login = login;
		this.password = password;
		this.registrationDate = registrationDate;
		this.lastLoginDate = lastLoginDate;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}
	public String getLastLoginDate() {
		return lastLoginDate;
	}
	public void setLastLoginDate(String lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public List<Character> getCharacters() {
		return characters;
	}

	public void setCharacters(List<Character> characters) {
		this.characters = characters;
	}
	
}
