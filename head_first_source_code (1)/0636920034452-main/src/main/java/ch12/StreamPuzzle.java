package ch12;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// This program uses Java Streams to display the top 5 least-played songs and search for the first song by a specific artist.

public class StreamPuzzle {
  public static void main(String[] args) {
    // Create a SongSearch object which has access to a list of songs
    SongSearch songSearch = new SongSearch();

    // Print the 5 songs that were played the least
    songSearch.printTopFiveSongs();

    // Search and print the first song by The Beatles
    songSearch.search("The Beatles");

    // Search and print the first song by The Beach Boys
    songSearch.search("The Beach Boys");
  }
}

// Class that handles song searching and ranking operations
class SongSearch {
  // List of songs fetched from the JukeboxData.Songs data source
  private final List<Song> songs = new JukeboxData.Songs().getSongs();

  // Prints the titles of the 5 songs with the lowest play counts
  void printTopFiveSongs() {
    List<String> topFive = songs.stream()
            .sorted(Comparator.comparingInt(Song::getTimesPlayed)) // Sort by times played (ascending)
            .map(Song::getTitle) // Extract only the song titles
            .limit(5) // Take only the first 5
            .collect(Collectors.toList()); // Collect into a list
    System.out.println(topFive);
  }

  // Searches for the first song by a given artist and prints its title if found
  void search(String artist) {
    Optional<Song> result = songs.stream()
            .filter(song -> song.getArtist().equals(artist)) // Match by artist name
            .findFirst(); // Get the first matching song (if any)

    if (result.isPresent()) {
      System.out.println(result.get().getTitle()); // Print the title if present
    } else {
      System.out.println("No songs found by: " + artist); // Message if not found
    }
  }
}
