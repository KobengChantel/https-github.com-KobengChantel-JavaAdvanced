package Lesson4;

// This program demonstrates creating and printing an immutable Contacts object whose state cannot be changed after creation.

public class TestImmutable {
    // immutable classes can't be changed or extended
    public static void main(String[] args) {
        // Create a Contacts object with first and last name
        Contacts c = new Contacts("Jada", "Mathele");

        // Print the Contacts object (likely calls overridden toString method)
        System.out.println(c);
    }
}
