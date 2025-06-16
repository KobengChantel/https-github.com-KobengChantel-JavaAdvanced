package ch12;

import java.util.List;
import java.util.stream.Collectors;

// This class prints reports about the song data, such as all distinct genres from the JukeboxData class.
public class JukeboxReports {
  public static void main(String[] args) {
    printAllGenres(); // Call method to print all genres
  }

  // This method prints all unique genres found in the song list
  static void printAllGenres() {
    // Get the list of songs from JukeboxData.Songs
    List<Song> songs = new JukeboxData.Songs().getSongs();

    // Extract and print all unique genres
    List<String> genres = songs.stream()
            .map(Song::getGenre) // extract genre from each Song
            .distinct() // remove duplicates
            .sorted() // sort alphabetically
            .collect(Collectors.toList()); // collect into a List

    System.out.println("Genres:");
    genres.forEach(System.out::println); // print each genre
  }
}
