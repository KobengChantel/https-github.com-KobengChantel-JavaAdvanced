package ch2;

// This code creates two Echo objects, calls their hello method in a loop while manipulating their count variables, and prints the final count of the second Echo object.
public class EchoTestDrive {
  public static void main(String[] args) {
    Echo e1 = new Echo();        // Create first Echo object
    Echo e2 = new Echo();        // Create second Echo object (independent instance)
//  - or -
//    Echo e2 = e1;              // Alternative: e2 references the same object as e1 (bonus answer "24")

    int x = 0;
    while (x < 4) {
      e1.hello();                // Print "helloooo..." from e1
      e1.count = e1.count + 1;   // Increment e1's count by 1

      if (x == 3) {
        e2.count = e2.count + 1; // At x=3, increment e2's count by 1
      }

      if (x > 0) {
        e2.count = e2.count + e1.count; // After first iteration, add e1's count to e2's count
      }

      x = x + 1;
    }

    System.out.println(e2.count); // Print final value of e2's count
  }
}

class Echo {
  int count = 0;  // Integer count initialized to 0

  void hello() {
    System.out.println("helloooo... ");  // Print greeting
  }
}
