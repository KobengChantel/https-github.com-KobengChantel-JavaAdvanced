package ch1;

// This code sets up two integer variables and prints pairs of their values in a loop, incrementing one variable while the other remains unchanged.

class Test {
  public static void main(String[] args) {
    int x = 0;       // Initialize x to 0
    int y = 0;       // Initialize y to 0
    while (x < 5) {  // Loop while x is less than 5
      //
      // candidate code goes here
      //

      System.out.print(x + "" + y + " ");  // Print current values of x and y concatenated with a space
      x = x + 1;                           // Increment x by 1
    }
  }
}



//        y = x - y;      00 11 21 32 42
//
//        y = y + x;      00 11 23 36 410
//
//        y = y + 2;      02 14 25 36 47
//        if( y > 4 ) {
//        y = y - 1;
//        }
//
//        x = x + 1;      11 34 59
//        y = y + x;
//
//        if ( y < 5 ) {  02 14 36 48
//        x = x + 1;
//        if ( y < 3 ) {
//        x = x - 1;
//        }
//        }
//        y = y + 2;




