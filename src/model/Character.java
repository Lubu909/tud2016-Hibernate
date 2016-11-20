package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name = "character.all", query = "SELECT c FROM Character c"),
	@NamedQuery(name = "character.byNick", query = "SELECT c FROM Character c WHERE c.nick = :nick")
})
public class Character {
	private int idCharacter;
	private String nick;
	private String characterClass;
	private String characterRace;
	private int level;
	
	//private Account account;
	
	public Character(){
	}
	
	public Character(int idCharacter, String nick, String characterClass, String characterRace, int level) {
		super();
		this.idCharacter = idCharacter;
		this.nick = nick;
		this.characterClass = characterClass;
		this.characterRace = characterRace;
		this.level = level;
	}
	
	public Character(String nick, String characterClass, String characterRace, int level) {
		super();
		this.nick = nick;
		this.characterClass = characterClass;
		this.characterRace = characterRace;
		this.level = level;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdCharacter() {
		return idCharacter;
	}
	public void setIdCharacter(int idCharacter) {
		this.idCharacter = idCharacter;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getCharacterClass() {
		return characterClass;
	}
	public void setCharacterClass(String characterClass) {
		this.characterClass = characterClass;
	}
	public String getCharacterRace() {
		return characterRace;
	}
	public void setCharacterRace(String characterRace) {
		this.characterRace = characterRace;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
/*
	@ManyToOne
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
*/
}
