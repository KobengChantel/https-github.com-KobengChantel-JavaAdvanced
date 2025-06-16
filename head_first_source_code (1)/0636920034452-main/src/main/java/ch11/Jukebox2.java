package ch11;

import java.util.*;

// This program retrieves a list of SongV2 objects and attempts to sort them, but sorting fails because SongV2 does not implement Comparable.

public class Jukebox2 {
  public static void main(String[] args) {
    new Jukebox2().go(); // Creates an instance and calls the go() method
  }

  public void go() {
    // Gets a list of SongV2 objects from MockSongs
    List<SongV2> songList = MockSongs.getSongsV2();

    // Prints the unsorted list
    System.out.println(songList);

    // This line is commented out because it would cause a compile-time error:
    // SongV2 doesn't implement Comparable, so the list can't be sorted using Collections.sort
//    Collections.sort(songList);

    // Prints the list again (still unsorted)
    System.out.println(songList);
  }
}
