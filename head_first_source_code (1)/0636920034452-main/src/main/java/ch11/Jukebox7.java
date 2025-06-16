package ch11;

import java.util.*;

// This program fetches a list of SongV3 objects from MockMoreSongs and demonstrates sorting them by title and artist using lambda expressions.

public class Jukebox7 {
  public static void main(String[] args) {
    new Jukebox7().go(); // Creates an instance and runs the sorting demo
  }

  public void go() {
    // Retrieves a list of SongV3 objects from MockMoreSongs
    List<SongV3> songList = MockMoreSongs.getSongsV3();

    // Prints the original unsorted list
    System.out.println(songList);

    // Sorts the list by song title using a lambda expression
    songList.sort((one, two) -> one.getTitle().compareTo(two.getTitle()));
    System.out.println(songList);

    // Sorts the list by artist name using a lambda expression
    songList.sort((one, two) -> one.getArtist().compareTo(two.getArtist()));
    System.out.println(songList);
  }
}
