package appB;

// This class demonstrates key concepts about String immutability in Java,
// including how string methods create new objects, string interning,
// and efficient string concatenation using StringBuilder.

public class StringImmutability {
  public static void main(String[] args) {
    stringMethodsCreateNewObjects();
  }

  // Shows that String methods like toUpperCase() do not modify the original string
  // but instead create and return new String objects
  static void stringMethodsCreateNewObjects() {
    String string = "the text";
    String upperStr = string.toUpperCase();

    System.out.println(string);          // prints original string: "the text"
    System.out.println(upperStr);        // prints uppercase string: "THE TEXT"
    System.out.println(string.equals(upperStr)); // prints false because content differs
  }

  // Demonstrates string interning: identical string literals point to the same object in memory
  static void stringsOfTheSameValueAreTheSameObject() {
    String str1 = "customer";
    String str2 = "customer";
    System.out.println(str1 == str2);    // prints true because both refer to the same interned string
  }

  // Inefficient way to concatenate strings using repeated `+` operator, which creates many intermediate objects
  String stringConcatenation() {
    String s = "0";
    for (int i = 1; i < 10; i++) {
      s = s + i;
    }
    return s;
  }

  // Efficient way to concatenate strings using StringBuilder, which mutates the same buffer
  String stringBuilder() {
    StringBuilder s = new StringBuilder("0");
    for (int i = 1; i < 10; i++) {
      s.append(i);
    }
    return s.toString();
  }
}
