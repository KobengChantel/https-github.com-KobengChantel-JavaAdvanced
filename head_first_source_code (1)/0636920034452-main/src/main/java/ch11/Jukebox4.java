package ch11;

import java.util.*;

// This program retrieves a list of SongV3 objects, first sorts them by natural order, then re-sorts them by artist name using a custom Comparator.

public class Jukebox4 {
  public static void main(String[] args) {
    new Jukebox4().go(); // Creates an instance and starts the sorting demo
  }

  public void go() {
    // Retrieves a list of SongV3 objects from MockSongs
    List<SongV3> songList = MockSongs.getSongsV3();

    // Prints the unsorted list
    System.out.println(songList);

    // Sorts the list using the natural order defined in SongV3
    Collections.sort(songList);
    System.out.println(songList);

    // Creates a Comparator to sort by artist name
    ArtistCompare artistCompare = new ArtistCompare();

    // Sorts the list using the custom artist comparator
    songList.sort(artistCompare);
    System.out.println(songList);
  }
}

// Custom Comparator that compares SongV3 objects by artist name
class ArtistCompare implements Comparator<SongV3> {
  public int compare(SongV3 one, SongV3 two) {
    return one.getArtist().compareTo(two.getArtist());
  }
}
