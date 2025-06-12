package appB.old;

import java.util.Objects;

// This class defines a Customer with an ID and name, and provides equality, hashing, and string representation logic.

public class Customer {
  // Fields to store customer ID and name
  private final int id;
  private final String name;

  // Constructor to initialize customer fields
  public Customer(int id, String name) {
    this.id = id;
    this.name = name;
  }

  // Getter for customer ID
  public int getId() {
    return id;
  }

  // Getter for customer name
  public String getName() {
    return name;
  }

  // Overrides equals to compare customers by ID and name
  @Override
  public boolean equals(Object obj) {
    if (obj == this) { // Same object reference
      return true;
    }
    if (obj == null || obj.getClass() != this.getClass()) { // Null or different class
      return false;
    }
    var that = (Customer) obj;
    return this.id == that.id &&
            Objects.equals(this.name, that.name); // Compare ID and name
  }

  // Overrides hashCode to ensure consistent behavior with equals
  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }

  // Returns a readable string representation of the customer
  @Override
  public String toString() {
    return "Customer{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
  }
}
