package ch11;

import java.util.*;

// This program gets a list of song titles, prints it, sorts the list alphabetically, and prints it again.

public class Jukebox1 {
  public static void main(String[] args) {
    new Jukebox1().go(); // Creates an instance and calls the go() method
  }

  public void go() {
    // Retrieves a list of song titles from MockSongs
    List<String> songList = MockSongs.getSongStrings();

    // Prints the unsorted list
    System.out.println(songList);

    // Sorts the list in alphabetical order
    Collections.sort(songList);

    // Prints the sorted list
    System.out.println(songList);
  }
}
