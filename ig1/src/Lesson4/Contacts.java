package Lesson4;

// This class represents an immutable contact with a first name and last name.

public final class Contacts {

    // Contact's first name (cannot be changed after creation)
    private final String firstName;

    // Contact's last name (cannot be changed after creation)
    private final String lastName;

    // Constructor initializes both first and last names
    public Contacts(String fname, String lname) {
        this.firstName = fname;
        this.lastName = lname;
    }

    // Getter for first name
    public String getFirstName() {
        return firstName;
    }

    // Getter for last name
    public String getLastName() {
        return lastName;
    }

    // Provides a string representation of the contact object
    @Override
    public String toString() {
        return "Contacts{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

}
