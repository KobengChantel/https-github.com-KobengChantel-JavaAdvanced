package ch11;

import java.util.*;

// This program demonstrates sorting a list of SongV4 objects by title and then storing them in a TreeSet for natural ordering, and alternatively creating a TreeSet sorted by bpm using a custom comparator.

public class Jukebox10 {
  public static void main(String[] args) {
    new Jukebox10().go(); // Runs the natural ordering demo by title and TreeSet creation
  }

  public void go() {
    // Retrieves a list of SongV4 objects from MockMoreSongs
    List<SongV4> songList = MockMoreSongs.getSongsV4();

    // Prints the original unsorted list
    System.out.println(songList);

    // Sorts the list by song title using a lambda comparator
    songList.sort((one, two) -> one.getTitle().compareTo(two.getTitle()));
    System.out.println(songList);

    // Creates a TreeSet from the list that orders songs by their natural order (assumed to be implemented in SongV4)
    Set<SongV4> songSet = new TreeSet<>(songList);
    System.out.println(songSet);
  }

  public void go2() {
    // Retrieves the same list of SongV4 objects
    List<SongV4> songList = MockMoreSongs.getSongsV4();

    // Creates a TreeSet with a custom comparator that sorts songs by their bpm (beats per minute)
    Set<SongV4> songSet = new TreeSet<>((o1, o2) -> o1.getBpm() - o2.getBpm());
    songSet.addAll(songList);
    System.out.println(songSet);
  }
}
