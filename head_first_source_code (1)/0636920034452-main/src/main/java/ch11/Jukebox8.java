package ch11;

import java.util.*;

// This program retrieves a list of SongV3 objects, sorts them by title, and then creates and prints a HashSet from that list to demonstrate set behavior.

public class Jukebox8 {
  public static void main(String[] args) {
    new Jukebox8().go(); // Creates an instance and runs the demo
  }

  public void go() {
    // Retrieves a list of SongV3 objects from MockMoreSongs
    List<SongV3> songList = MockMoreSongs.getSongsV3();

    // Prints the original unsorted list
    System.out.println(songList);

    // Sorts the list by song title using a lambda expression
    songList.sort((one, two) -> one.getTitle().compareTo(two.getTitle()));
    System.out.println(songList);

    // Converts the sorted list to a HashSet to demonstrate a set's uniqueness and unordered nature
    Set<SongV3> songSet = new HashSet<>(songList);
    System.out.println(songSet);
  }
}
