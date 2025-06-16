package ch11;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

// This program retrieves a list of SongV4 objects, sorts them by title using a lambda expression, then converts the list into a HashSet to demonstrate set behavior.

public class Jukebox9 {
  public static void main(String[] args) {
    new Jukebox9().go(); // Creates an instance and runs the sorting and set demo
  }

  public void go() {
    // Retrieves a list of SongV4 objects from MockMoreSongs
    List<SongV4> songList = MockMoreSongs.getSongsV4();

    // Prints the original unsorted list
    System.out.println(songList);

    // Sorts the list by song title
    songList.sort((one, two) -> one.getTitle().compareTo(two.getTitle()));
    System.out.println(songList);

    // Creates a HashSet from the list to show uniqueness and unordered properties
    Set<SongV4> songSet = new HashSet<>(songList);
    System.out.println(songSet);
  }
}
