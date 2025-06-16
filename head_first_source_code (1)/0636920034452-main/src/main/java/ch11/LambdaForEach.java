package ch11;

import java.util.Collections;
import java.util.List;

// This program demonstrates iterating over a list of SongV3 objects using a lambda expression with forEach, then prints the list before and after sorting it naturally.

public class LambdaForEach {

  public static void main(String[] args) {
    new LambdaForEach().go(); // Creates an instance and runs the demo
  }

  public void go() {
    // Retrieves a list of SongV3 objects from MockSongs
    List<SongV3> mySongs = MockSongs.getSongsV3();

    // Uses a lambda expression to print each song individually
    mySongs.forEach(mySong -> System.out.println(mySong));

    // Prints the entire list using toString
    System.out.println(mySongs);

    // Sorts the list in natural order (based on Comparable implementation in SongV3)
    Collections.sort(mySongs);
    System.out.println(mySongs);
  }
}
