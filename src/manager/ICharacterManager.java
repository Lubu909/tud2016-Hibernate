package manager;

import java.util.List;

import model.Character;

public interface ICharacterManager {
	public void addCharacter(Character character);
	public void delCharacter(Character character);
	public Character getCharacter(int id);
	public Character getCharacter(String nick);
	public List<Character> getAllCharacters();
}
