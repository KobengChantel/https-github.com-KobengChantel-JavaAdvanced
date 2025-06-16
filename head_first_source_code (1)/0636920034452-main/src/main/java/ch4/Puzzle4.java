package ch4;

// This code creates an array of Value objects with increasing intValue powers of 10, then calculates a result by calling doStuff on each Value in reverse order, which multiplies intValue by a factor depending on its size, and finally prints the accumulated result.

public class Puzzle4 {
  public static void main(String[] args) {
    Value[] values = new Value[6];  // Create array to hold 6 Value objects
    int number = 1;
    int i = 0;
    while (i < 6) {                // Loop to initialize Value objects
      values[i] = new Value();     // Create new Value object
      values[i].intValue = number; // Set intValue to current number
      number = number * 10;        // Increase number by factor of 10 each iteration
      i = i + 1;
    }

    int result = 0;
    i = 6;
    while (i > 0) {               // Loop in reverse order
      i = i - 1;
      result = result + values[i].doStuff(i);  // Add modified value to result
    }
    System.out.println("result " + result);
  }
}

class Value {
  int intValue;

  public int doStuff(int factor) {  // Returns intValue multiplied by factor based on value size
    if (intValue > 100) {
      return intValue * factor;     // If intValue > 100, multiply by factor
    } else {
      return intValue * (5 - factor); // Otherwise multiply by (5 - factor)
    }
  }
}
