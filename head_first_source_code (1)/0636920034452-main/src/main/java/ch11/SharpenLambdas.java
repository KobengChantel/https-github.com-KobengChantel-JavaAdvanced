package ch11;

import java.util.List;

// Demonstrates sorting a list of SongV3 objects using lambda expressions to sort by BPM ascending and then by title descending.

public class SharpenLambdas {
  public static void main(String[] args) {
    new SharpenLambdas().go();
  }

  public void go() {
    List<SongV3> songList = MockSongs.getSongsV3();
    System.out.println(songList);

    // Sort songs by BPM in ascending order
    songList.sort((one, two) -> one.getBpm() - two.getBpm());
    System.out.println(songList);

    // Sort songs by title in descending alphabetical order
    songList.sort((one, two) -> two.getTitle().compareTo(one.getTitle()));
    System.out.println(songList);
  }
}
