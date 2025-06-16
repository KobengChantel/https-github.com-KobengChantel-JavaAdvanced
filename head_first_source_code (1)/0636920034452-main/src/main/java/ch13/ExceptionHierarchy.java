package ch13;

// Demonstrates catching multiple related exceptions in a try-catch block, with specific handling for subclasses first.

public class ExceptionHierarchy {
  private Laundry laundry;

  // Calls laundry.doLaundry() and catches specific exceptions in order:
  // TeeShirtException, LingerieException, then the more general ClothingException
  void catchMultipleExceptions() {
    try {
      laundry.doLaundry();

    } catch (TeeShirtException tex) {
      // recovery from TeeShirtException

    } catch (LingerieException lex) {
      // recovery from LingerieException

    } catch (ClothingException cex) {
      // recovery from all other ClothingExceptions
    }
  }
}
