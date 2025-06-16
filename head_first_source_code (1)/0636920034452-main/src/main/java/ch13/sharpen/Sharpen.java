package ch13.sharpen;

// This class demonstrates catching multiple related exceptions thrown by a Risky operation using a try-catch block.

public class Sharpen {
  // Instantiate Risky class which has methods that can throw exceptions
  private Risky x = new Risky();

  // Method that calls risky code and catches various exceptions in specific order
  void catchExceptions() {
    try {
      x.doRisky(); // Method that throws DeltaEx (and subclasses)
    } catch (AlphaEx a) {
      // Handle AlphaEx exception (subclass of BetaEx/GammaEx/DeltaEx)
    } catch (BetaEx b) {
      // Handle BetaEx exception
    } catch (GammaEx c) {
      // Handle GammaEx exception
    } catch (DeltaEx d) {
      // Handle DeltaEx exception (base checked exception)
    }
  }

  public static void main(String[] args) {
    new Sharpen().catchExceptions(); // Run the exception catching example
  }
}
