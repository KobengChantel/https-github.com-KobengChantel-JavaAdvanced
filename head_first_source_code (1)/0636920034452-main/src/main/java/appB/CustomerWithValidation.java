package appB;

import java.util.Objects;

// This code defines a CustomerWithValidation record that enforces validation on the id field,
// overrides equals and hashCode to consider only the id for equality,
// and includes a placeholder method for additional name validation.

public record CustomerWithValidation(int id, String name) {
  // Compact constructor that validates the id upon object creation
  public CustomerWithValidation {
    if (id < 0) {
      throw new ValidationException();
    }
  }

  // Override equals to compare Customers only by their id field
  @Override
  public boolean equals(Object o) {
    return id == ((CustomerWithValidation) o).id;
  }

  // Override hashCode to be consistent with equals, using only id
  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  // Placeholder for additional name validation logic
  private boolean isValidName(String name) {
    // some implementation
    return true;
  }
}
