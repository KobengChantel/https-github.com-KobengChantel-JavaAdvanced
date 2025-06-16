package ch11;

import java.util.*;

// This program retrieves a list of SongV3 objects and demonstrates sorting the list first by title and then by artist using two inner Comparator classes.

public class Jukebox5 {
  public static void main(String[] args) {
    new Jukebox5().go(); // Creates an instance and runs the sorting demo
  }

  public void go() {
    // Retrieves a list of SongV3 objects from MockSongs
    List<SongV3> songList = MockSongs.getSongsV3();

    // Prints the original list
    System.out.println(songList);

    // Creates a comparator to sort by song title
    TitleCompare titleCompare = new TitleCompare();
    songList.sort(titleCompare);
    System.out.println(songList);

    // Creates a comparator to sort by artist name
    ArtistCompare artistCompare = new ArtistCompare();
    songList.sort(artistCompare);
    System.out.println(songList);
  }

  // Inner Comparator class to compare songs by title
  class TitleCompare implements Comparator<SongV3> {
    public int compare(SongV3 one, SongV3 two) {
      return one.getTitle().compareTo(two.getTitle());
    }
  }

  // Inner Comparator class to compare songs by artist
  class ArtistCompare implements Comparator<SongV3> {
    public int compare(SongV3 one, SongV3 two) {
      return one.getArtist().compareTo(two.getArtist());
    }
  }
}
