package ch11;

import java.util.*;

// This program retrieves a list of SongV3 objects, sorts them using their natural ordering (since SongV3 implements Comparable), and prints the list before and after sorting.

public class Jukebox3 {
  public static void main(String[] args) {
    new Jukebox3().go(); // Creates an instance and calls the go() method
  }

  public void go() {
    // Retrieves a list of SongV3 objects from MockSongs
    List<SongV3> songList = MockSongs.getSongsV3();

    // Prints the original unsorted list
    System.out.println(songList);

    // Sorts the list using natural order defined in SongV3 (implements Comparable)
    Collections.sort(songList);

    // Prints the sorted list
    System.out.println(songList);
  }
}
