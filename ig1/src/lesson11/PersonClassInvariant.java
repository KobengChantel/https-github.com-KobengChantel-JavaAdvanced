package lesson11;

/**
 * This class demonstrates the use of a class invariant checked by an assertion to ensure age validity before allowing name changes.
 */
public class PersonClassInvariant {
    String name;
    String ssn;
    int age;

    // Method to check the class invariant that age must be between 18 and 149 inclusive
    private void checkAge() {
        assert age >= 18 && age < 150 : "Age must be between 18 and 149";
    }

    // Method to change the person's name but only after verifying the age invariant
    public void changeName(String fname) {
        checkAge();
        name = fname;
    }

    public static void main(String args[]) {
        // Create a new PersonClassInvariant object
        PersonClassInvariant person1 = new PersonClassInvariant();

        // Set age and initial name
        person1.age = 15;  // This will cause assertion failure when changeName is called
        person1.name = "dave";

        // Attempt to change name, triggering age check and assertion failure because age < 18
        person1.changeName("David");
    }
}
