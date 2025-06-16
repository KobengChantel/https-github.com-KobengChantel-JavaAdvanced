package ch11;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// This class demonstrates various ways to sort a list of SongV3 objects using different sorting criteria.
public class Sorting {
  public static void main(String[] args) {

    // Get a list of SongV3 objects from a mock data source
    List<SongV3> songList = MockSongs.getSongsV3();

    // Sort the songs by title in ascending alphabetical order and print the list
    songList.sort((song1, song2) -> song1.getTitle().compareTo(song2.getTitle()));
    System.out.println(songList);

    // Sort the songs by title in descending alphabetical order and print the list
    songList.sort((song1, song2) -> song2.getTitle().compareTo(song1.getTitle()));
    System.out.println(songList);

    // Sort the songs by title in descending alphabetical order using a negation trick and print the list
    songList.sort((song1, song2) -> -song1.getTitle().compareTo(song2.getTitle()));
    System.out.println(songList);

    // Sort the songs by artist name in ascending alphabetical order and print the list
    songList.sort((song1, song2) -> song1.getArtist().compareTo(song2.getArtist()));
    System.out.println(songList);

    // Sort the songs by BPM (beats per minute) in ascending order and print the list
    songList.sort((song1, song2) -> song1.getBpm() - song2.getBpm());
    System.out.println(songList);
  }

  // Method showing alternative sorting using method references and lambda expressions
  void methodReferences(List<SongV3> songList) {
    // Sort using Collections.sort and Comparator.comparing with a method reference for title
    Collections.sort(songList, Comparator.comparing(SongV3::getTitle));
    // Sort using List.sort with a lambda comparator for title
    songList.sort((song1, song2) -> song1.getTitle().compareTo(song2.getTitle()));

  }
}
