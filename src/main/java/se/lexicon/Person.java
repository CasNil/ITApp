package se.lexicon;

public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private String email;

    public Person(int id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;

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
    public String getSummary() {
        return "id: " + id + ", name: " + firstName + " " + lastName + ", email: " + email;
    }
}
