package appB;

import org.jetbrains.annotations.NotNull;

// This file demonstrates the use of common Java annotations such as @NotNull, @Override, and @FunctionalInterface
// to enforce constraints, ensure proper method overrides, and define a functional interface.

// This class shows how @NotNull can be applied to fields, parameters, and return types
public class AnnotationExamples {
  // This field should not be null
  private @NotNull String cannotBeNull = "some value";

  // This method enforces that the parameter should never be null
  void cannotTakeNullParameter(@NotNull String str) {
    // Local variable declared with @NotNull, though not assigned here
    @NotNull String val;
    // Accessing length of str assuming it's not null
    System.out.println(str.length());
  }

  // This method incorrectly promises not to return null (violates @NotNull)
  @NotNull
  String cannotReturnNullValue() {
    return null;  // Tools like IntelliJ will flag this as problematic
  }

  // Overriding toString method with @Override annotation
  @Override
  public String toString() {
    return "AnnotationExamples{" +
            "cannotBeNull='" + cannotBeNull + '\'' +
            '}';
  }
}

// A functional interface can have only one abstract method, used in lambda expressions or method references
@FunctionalInterface
interface IntToString {
  // The single abstract method of the interface
  String convert(int value);

  // Uncommenting the line below would violate the @FunctionalInterface contract
  // void anotherAbstractMethod();
}
