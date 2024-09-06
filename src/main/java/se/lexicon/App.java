package se.lexicon;

import se.lexicon.dao.PersonDAO;
import se.lexicon.dao.impl.PersonDAOImpl;
import se.lexicon.model.AppRole;
import se.lexicon.model.AppUser;
import se.lexicon.model.Person;

import java.util.Collection;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        PersonDAO personDAO = new PersonDAOImpl();

       /* String nameToSearch = "Adam";
        Collection<Person> persons = personDAO.findByName(nameToSearch);

        if (persons.isEmpty()) {
            System.out.println("No person found with name: " + nameToSearch);
        } else {
            for (Person person : persons) {
                System.out.println("Found person: " + person.getFirstName() + " " + person.getLastName());
            }
        }

        */
    }

}
