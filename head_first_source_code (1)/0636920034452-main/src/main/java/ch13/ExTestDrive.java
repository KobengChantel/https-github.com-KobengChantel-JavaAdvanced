package ch13;

// Custom checked exception class
class MyEx extends Exception { }

public class ExTestDrive {
  public static void main(String[] args) {
    String test = args[0];  // Read first command line argument

    try {
      System.out.print("t");          // Print 't' before risky operation
      doRisky(test);                  // Call method that may throw MyEx
      System.out.print("o");          // Print 'o' if no exception thrown
    } catch (MyEx e) {
      System.out.print("a");          // Print 'a' if MyEx is caught
    } finally {
      System.out.print("w");          // Always print 'w' after try or catch
    }
    System.out.println("s");          // Finally print 's' and newline
  }

  static void doRisky(String t) throws MyEx {
    System.out.print("h");            // Print 'h' on method entry

    if ("yes".equals(t)) {            // If input string equals "yes"
      throw new MyEx();               // Throw custom exception
    }

    System.out.print("r");            // Print 'r' if no exception thrown
  }
}
