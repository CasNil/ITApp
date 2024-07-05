package se.lexicon;

import java.util.Objects;

public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private AppUser credentials;

    public Person(int id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;

    }

    public AppUser getCredentials() {
        return credentials;
    }

    public void setCredentials(AppUser credentials) {
        this.credentials = credentials;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getId() {
        return id;
    }

    public void setFirstName(String firstName) {
        if (firstName == null) throw new IllegalArgumentException("Firstname is not allowed to be null!");
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (firstName == null) throw new IllegalArgumentException("Lastname is not allowed to be null!");
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (firstName == null) throw new IllegalArgumentException("Email is not allowed to be null!");

        this.email = email;
    }

    @Override
    public String toString() {
        return "id: " + id + ", name: " + firstName + " " + lastName + ", email: " + email;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        return (Objects.equals(firstName, ((Person) obj).firstName) && Objects.equals(lastName, ((Person) obj).lastName) && Objects.equals(email, ((Person) obj).email));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Objects.hashCode(id);
        result = prime * result + Objects.hashCode(firstName);
        result = prime * result + Objects.hashCode(lastName);
        result = prime * result + Objects.hashCode(email);

        return result;
    }
}
