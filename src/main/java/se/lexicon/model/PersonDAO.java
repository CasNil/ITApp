package se.lexicon.model;

import java.util.Collection;

public interface PersonDAO {
    Person persist(String person);

    Person findById(int id);

    Person findByEmail(String email);

    Collection<Person> findAll();

    void remove(int id);

}
