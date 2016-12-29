package com.tud2016Hibernate.manager;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.tud2016Hibernate.model.Character;

@Component
@Transactional
public class CharacterManagerHibernateImpl implements CharacterManager {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addCharacter(Character character) {
		this.sessionFactory.getCurrentSession().persist(character);

	}

	@Override
	public void delCharacter(Character character) {
		character = (Character) this.sessionFactory.getCurrentSession().get(Character.class, character.getIdCharacter());
		this.sessionFactory.getCurrentSession().delete(character);
	}

	@Override
	public Character getCharacter(int id) {
		return (Character) this.sessionFactory.getCurrentSession().get(Character.class, id);
	}

	@Override
	public Character getCharacter(String nick) {
		return (Character) this.sessionFactory.getCurrentSession().getNamedQuery("character.byNick").setString("nick", nick).uniqueResult();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Character> getAllCharacters() {
		return this.sessionFactory.getCurrentSession().getNamedQuery("character.all").list();
	}

}
