package ch3;

// This program demonstrates using an integer array as an index to access and print elements from a string array in a custom order.

class TestArrays {
  public static void main(String[] args) {
    int[] index = new int[4];        // Array to hold indexes
    index[0] = 1;                    // Points to islands[1]
    index[1] = 3;                    // Points to islands[3]
    index[2] = 0;                    // Points to islands[0]
    index[3] = 2;                    // Points to islands[2]

    String[] islands = new String[4]; // Array of island names
    islands[0] = "Bermuda";
    islands[1] = "Fiji";
    islands[2] = "Azores";
    islands[3] = "Cozumel";

    int y = 0;
    int ref;

    // Loop through index array, use each element as an index to access islands, and print the island name
    while (y < 4) {
      ref = index[y];
      System.out.print("island = ");
      System.out.println(islands[ref]);
      y = y + 1;
    }
  }
}
