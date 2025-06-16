package ch4;

// This code attempts to create and manipulate an array of Mix4 objects, incrementing counters and conditionally creating new Mix4 instances, but the loop and conditionals are commented out making it incomplete.

public class Mix4 {
  int counter = 0;

  public static void main(String[] args) {
    int count = 0;
    Mix4[] mixes = new Mix4[20];
    int i = 0;
    // while () {                // Loop condition missing, so loop is commented out
    mixes[i] = new Mix4();     // Create a new Mix4 object at index i
    mixes[i].counter = mixes[i].counter + 1;  // Increment counter of this object
    count = count + 1;         // Increment count
    count = count + mixes[i].maybeNew(i);  // Add result of maybeNew to count
    i = i + 1;                 // Increment index
    // }
    System.out.println(count + " " +
            mixes[1].counter);  // Print total count and counter of mixes[1]
  }

  public int maybeNew(int index) {
    // if (             ) {         // Condition commented out, so always runs
    Mix4 mix = new Mix4();        // Create new Mix4 object
    mix.counter = mix.counter + 1;  // Increment its counter
    return 1;                    // Return 1 to add to count
    // }
    // return 0;
  }
}
