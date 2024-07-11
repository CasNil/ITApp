package se.lexicon.dao.impl;

import se.lexicon.dao.PersonDAO;
import se.lexicon.model.Person;
import se.lexicon.sequencers.PersonIdSequencer;

import java.util.ArrayList;
import java.util.List;

public class PersonDAOImpl implements PersonDAO {

    private final List<Person> people;

    private PersonDAOImpl() {
        people = new ArrayList<>();
    }

    @Override
    public Person persist(Person person) {
        if (person.getId() != 0) throw new IllegalArgumentException("Person id was not 0 ");
        if (findByEmail(person.getEmail()) != null) {
            throw new IllegalArgumentException("That email already exists! ");
        }
        person.setId(PersonIdSequencer.nextId());
        people.add(person);
        return person;
    }

    @Override
    public Person findById(int id) {
        for (Person person : people) {
            if (person.getId() == id) {
                return person;
            }
        }
        return null;
    }

    @Override
    public Person findByEmail(String email) {
        for (Person person : people) {
            if (person.getEmail().equalsIgnoreCase(email)) {
                return person;
            }
        }
        return null;
    }

    @Override
    public Person findByUsername(String username) {
        for (Person person : people) {
            if (person.getCredentials().getUsername().equalsIgnoreCase(username)) {
                return person;
            }
        }
        return null;
    }

    @Override
    public List<Person> findAll() {
        return new ArrayList<>(people);
    }

    @Override
    public void remove(int id) {
        Person person = findById(id);
        if (person != null) people.remove(person);
    }
}
