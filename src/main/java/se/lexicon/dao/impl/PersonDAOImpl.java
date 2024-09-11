package se.lexicon.dao.impl;

import se.lexicon.dao.PersonDAO;
import se.lexicon.helper.MySQLConnection;
import se.lexicon.model.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class PersonDAOImpl implements PersonDAO {


    @Override
    public Person create(Person person) {
        String query = "INSERT INTO person (first_name, last_name) VALUES (?,?)";

        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, person.getFirstName());
            preparedStatement.setString(2, person.getLastName());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        person.setId(generatedKeys.getInt(1));
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Collection<Person> findAll() {
        Collection<Person> personList = new ArrayList<>();
        try {
            Connection connection = MySQLConnection.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM person");

            while (rs.next()) {
                int personId = rs.getInt(1);
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);

                Person person = new Person(personId, firstName, lastName);
                personList.add(person);
            }
            personList.forEach(System.out::println);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personList;
    }

    @Override
    public Person findById(int id) {
        String query = "SELECT * FROM person WHERE person_id = ?";
        Person person = null;
        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);

            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    person = new Person(rs.getInt(1), rs.getString(2), rs.getString(3));
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return person;
    }

    @Override
    public Collection<Person> findByName(String name) {
        Collection<Person> personList = new ArrayList<>();
        String query = "SELECT first_name, last_name FROM person WHERE first_name = ? OR last_name = ?";
        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, name);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");

                personList.add(new Person(firstName, lastName));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personList;
    }

    @Override
    public Person update(Person person) {
        String query = "UPDATE person SET first_name = ?, last_name = ?, email = ? WHERE id = ?";

        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, person.getFirstName());
            preparedStatement.setString(2, person.getLastName());
            preparedStatement.setString(3, person.getEmail());
            preparedStatement.setInt(4, person.getId());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected == 0) {
                throw new SQLException("Updating person failed, no rows affected.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error updating person in the database", e);
        }
        return person;
    }

    @Override
    public boolean deleteById(int id) {
        String query = "DELETE FROM person WHERE id = ?";
        boolean isDeleted = false;

        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);

            int rowsAffected = preparedStatement.executeUpdate();

            isDeleted = (rowsAffected > 0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isDeleted;
    }
}
