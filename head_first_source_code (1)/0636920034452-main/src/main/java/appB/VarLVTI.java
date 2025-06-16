package appB;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.Files.newBufferedReader;
import static java.nio.file.Paths.get;

// This class demonstrates the usage rules, benefits, and caveats of using 'var' for local variable type inference introduced in Java 10.

public class VarLVTI {
  // Simple usage of var for local variables
  void simpleVar() {
    var name = "A Name";           // inferred as String
    var names = new ArrayList<>(); // inferred as ArrayList<Object>
  }

  // Using var to hold the result of a method call
  void varFromMethodCall() {
    var customers = getCustomers(); // inferred as List<Customer>
  }

  // Demonstrates that var must be initialized at declaration and its type is fixed
  void varMustBeDefinedStraightAway() {
    // invalid, var requires initialization
    // var name;

    var someValue = 1; // inferred as int

    // invalid, cannot assign a String to an int variable
    // someValue = "String";
  }

  // Highlights importance of meaningful variable names when using var
  void considerVariableNames() throws IOException {
    // clear and descriptive variable name
    var reader = newBufferedReader(get("/"));

    // unclear variable name, reduces readability
    var stuff = doTheThing();
  }

  // Shows how to program to interfaces explicitly vs. using var with concrete classes
  void programmingToInterface() {
    // declared as interface type List<String>
    List<String> list1 = new ArrayList<>();

    // inferred as concrete type ArrayList<String>
    var list2 = new ArrayList<String>();
  }

  // Caution: var with diamond operator can infer raw types or less specific types
  void doNotUseWithDiamondOperator() {
    // inferred as ArrayList<Object> due to diamond operator without type argument
    var list = new ArrayList<>();
  }

  private List<Customer> getCustomers() {
    return null;
  }

  private class Customer {
  }

  private String doTheThing() {
    return null;
  }
}
