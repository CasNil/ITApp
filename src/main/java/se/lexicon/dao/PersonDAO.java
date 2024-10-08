package se.lexicon.dao;

import se.lexicon.model.Person;

import java.util.Collection;
import java.util.List;

public interface PersonDAO {
    Person create(Person person);

    Collection<Person> findAll();

    Person findById(int id);

    Collection<Person> findByName(String name);

    Person update(Person person);

    boolean deleteById(int id);

}
