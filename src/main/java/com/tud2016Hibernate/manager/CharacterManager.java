package com.tud2016Hibernate.manager;

import java.util.List;

import com.tud2016Hibernate.model.Character;

public interface CharacterManager {
	public void addCharacter(Character character);
	public void delCharacter(Character character);
	public Character getCharacter(int id);
	public Character getCharacter(String nick);
	public List<Character> getAllCharacters();
}
