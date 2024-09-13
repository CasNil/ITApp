package se.lexicon.model;

import java.util.Objects;

public class Person {
    private int id;
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        if (firstName == null) throw new IllegalArgumentException("Firstname is not allowed to be null!");
        this.firstName = firstName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (firstName == null) throw new IllegalArgumentException("Lastname is not allowed to be null!");
        this.lastName = lastName;
    }


    @Override
    public String toString() {
        return "id: " + id + ", name: " + firstName + " " + lastName;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        return (Objects.equals(firstName, ((Person) obj).firstName) && Objects.equals(lastName, ((Person) obj).lastName));
    }
}
