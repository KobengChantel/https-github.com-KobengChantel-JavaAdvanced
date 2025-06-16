package appB;

// This class demonstrates the use of varargs (variable-length argument lists) in Java methods,
// including formatting strings with parameters and printing multiple objects or generic elements.

public class Varargs {
  // Formats messages using a fixed number of parameters with String.format
  void formatExample(String name, int number) {
    String msgName = String.format("Message for %s", name);
    String msgNumberName = String.format("%d, messages for %s", number, name);
  }

  // Prints all given objects using varargs of Object type
  void printAllObjects(Object... elements) {
    for (Object element : elements) {
      System.out.println(element);
    }
  }

  // Generic version that prints all given elements of any type using varargs
  <E> void printAllElements(E... elements) {
    for (E element : elements) {
      System.out.println(element);
    }
  }
}
