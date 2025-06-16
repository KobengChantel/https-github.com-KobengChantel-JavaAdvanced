package ch12;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

// This test class demonstrates various queries and operations on a collection of Song objects using Java Streams and other utilities.
class JukeboxQueriesTest {
  private JukeboxData.Songs songs;

  @BeforeEach
  void setUp() {
    // Initialize the songs collection before each test
    songs = new JukeboxData.Songs();
  }

  @Test
  void shouldOutputAllSongsPlayed() {
    // Retrieve all songs and print each one and then the entire list
    List<Song> allSongs = songs.getSongs();
    allSongs.forEach(song -> System.out.println(song));

    System.out.println(allSongs);
  }

  // STRAIGHTFORWARD
  // Sorting songs by times played ascending and collecting to list
  @Test
  void shouldOrderByLeastPlayed() {
    List<Song> allSongs = songs.getSongs();

    List<Song> result = allSongs.stream()
            .sorted(Comparator.comparingInt(Song::getTimesPlayed))
            .collect(Collectors.toList());

    System.out.println(result);
  }

  // CANDIDATE
  // Find top five most played songs using two sorting approaches
  @Test
  void shouldFindTopFiveSongs() {
    List<Song> allSongs = songs.getSongs();

    // Sort descending by times played with explicit comparator
    List<Song> result = allSongs.stream()
            .sorted((o1, o2) -> o2.getTimesPlayed() - o1.getTimesPlayed())
            .limit(5)
            .collect(Collectors.toList());
    System.out.println(result);

    // Reuse method reference with reversed comparator
    result = allSongs.stream()
            .sorted(Comparator.comparingInt(Song::getTimesPlayed).reversed())
            .limit(5)
            .collect(Collectors.toList());

    System.out.println(result);
  }

  // REGEX
  // Find artists with non-alphanumeric characters (excluding spaces)
  @Test
  void shouldFindNonStandardCharacters() {
    List<Song> allSongs = songs.getSongs();

    // Pattern to match characters other than letters, digits, and space
    Pattern pattern = Pattern.compile("[^A-Za-z0-9 ]");

    List<String> result = allSongs.stream()
            .map(Song::getArtist)
            .filter(artist -> pattern.matcher(artist).find())
            .collect(Collectors.toList());

    System.out.println("result = " + result);
  }

  @Test
  void shouldQueryForGenre() {
    List<Song> allSongs = songs.getSongs();
    // Retrieve distinct genres and print them
    List<String> genres = allSongs.stream()
            .map(song -> song.getGenre())
            .distinct()
            .collect(toList());
    System.out.println("genres = " + genres);

    // Count distinct genres
    System.out.println(allSongs.stream()
            .map(song -> song.getGenre())
            .distinct()
            .count());

    // Count how many songs per genre using grouping
    Map<String, Long> genreCount = allSongs.stream().map(song -> song.getGenre())
            .collect(groupingBy(Function.identity(), counting()));
    System.out.println("genreCount = " + genreCount);
  }

  // OPTIONAL
  // Find the song played the most times
  @Test
  void shouldFindMostPopularSong() {
    List<Song> allSongs = songs.getSongs();

    Optional<Song> result = allSongs.stream()
            .max(Comparator.comparingInt(Song::getTimesPlayed));

    System.out.println(result.get());
  }

  @Test
  void shouldFindMostPopularGenre() {
    List<Song> allSongs = songs.getSongs();

    // Aggregate total plays per genre using a HashMap and loop
    HashMap<String, Integer> genreCount = new HashMap<>();

    for (Song song : allSongs) {
      int timesPlayed = song.getTimesPlayed();
      String genre = song.getGenre();
      if (genreCount.get(genre) == null) {
        genreCount.put(genre, timesPlayed);
      } else {
        Integer integer = genreCount.get(genre);
        genreCount.put(genre, integer + timesPlayed);
      }
    }
    System.out.println("result = " + genreCount);
  }

  @Test
  void shouldSeeIfThereAreAnyRAndBSongs() {
    List<Song> allSongs = songs.getSongs();

    // Check if any song belongs to the "R&B" genre
    boolean result = allSongs.stream()
            .anyMatch(song -> song.getGenre().equals("R&B"));

    System.out.println("result = " + result);
  }

  @Test
  void shouldFindASong() {
    List<Song> allSongs = songs.getSongs();

    // Find the first song released in 1995 if any
    Optional<Song> result = allSongs.stream()
            .filter(song -> song.getYear() == 1995)
            .findFirst();

    System.out.println("result = " + result);
  }

  @Test
  void shouldFindDistinctArtists() {
    List<Song> allSongs = songs.getSongs();

    // Count how many unique artists are in the list
    long result = allSongs.stream()
            .map(Song::getArtist)
            .distinct()
            .count();

    System.out.println("result = " + result);
  }

  // CANDIDATE: exercise 1
  // Filter songs by genre "Rock" and collect them into a list
  @Test
  void shouldFindHowManySongsAreSomeSortOfRock() {
    List<Song> allSongs = songs.getSongs();

    List<Song> result = allSongs.stream()
            .filter(song -> song.getGenre().equals("Rock"))
            .collect(toList());

    System.out.println(result);
  }

  // GROUPING
  // Count the number of times each song title appears
  @Test
  void shouldFindNumberOfTimesSongTitleAppears() {
    List<Song> allSongs = songs.getSongs();

    Map<String, Long> result = allSongs.stream()
            .map(Song::getTitle)
            .collect(groupingBy(Function.identity(), counting()));

    System.out.println("result = " + result);
  }

  // GROUPING (alternate way)
  @Test
  void shouldFindNumberOfTimesSongTitleAppears2() {
    List<Song> allSongs = songs.getSongs();

    Map<String, Long> result = allSongs.stream()
            .collect(Collectors.groupingBy(Song::getTitle, Collectors.counting()));

    System.out.println("result = " + result);
  }

  // GROUPING
  // Output a comma-separated string of all artists
  @Test
  void shouldOutputCSVOfArtists() {
    List<Song> songs = this.songs.getSongs();

    System.out.println(songs.stream()
            .map(Song::getArtist)
            .collect(joining(",")));
  }

  // CANDIDATE
  // Find the oldest song by year using min terminal operation
  @Test
  void shouldGetOldestSong() {
    List<Song> allSongs = songs.getSongs();
    Optional<Song> result = allSongs.stream()
            .min(Comparator.comparingInt(Song::getYear));

    System.out.println("result = " + result.get());
  }

  @Test
  void shouldOrderBySongAge() {
    List<Song> allSongs = songs.getSongs();
    // Sort songs by year ascending
    List<Song> result = allSongs.stream()
            .sorted(Comparator.comparingInt(Song::getYear))
            .collect(toList());

    System.out.println("result = " + result);
  }

  // STRAIGHTFORWARD
  // Find all versions of a specific song title
  @Test
  void shouldBeAbleToFindAllVersionsOfASong() {
    List<Song> allSongs = songs.getSongs();

    String songTitle = "Hurt";
    List<Song> result = allSongs.stream()
            .filter(song -> song.getTitle().equals(songTitle))
            .collect(toList());

    System.out.println("result = " + result);
  }

  // CANDIDATE
  // Find all artists who performed a specific song excluding "The Beatles"
  @Test
  void shouldFindAllArtistsForASpecificSong() {
    List<Song> allSongs = songs.getSongs();

    String songTitle = "With a Little Help from My Friends";
    List<String> result = allSongs.stream()
            .filter(song -> song.getTitle().equals(songTitle))
            .map(song -> song.getArtist())
            .filter(artist -> !artist.equals("The Beatles"))
            .collect(Collectors.toList());

    System.out.println("result = " + result);
  }

  // CANDIDATE
  // More complex example: filter songs by title, sort by times played, then collect artists
  @Test
  void shouldComplexExample() {
    List<Song> allSongs = songs.getSongs();

    String songTitle = "With a Little Help from My Friends";
    // Imperative approach replacing commented stream version
    List<Song> toSort = new ArrayList<>();
    for (Song song : allSongs) {
      if (song.getTitle().equals(songTitle)) {
        toSort.add(song);
      }
    }
    toSort.sort(Comparator.comparing(Song::getTimesPlayed));
    List<String> result = new ArrayList<>();
    for (Song song : toSort) {
      String artist = song.getArtist();
      result.add(artist);
    }

    System.out.println("result = " + result);
  }

  // CANDIDATE
  // Primitive streams: get statistics on years of songs
  @Test
  void shouldQueryForYear() {
    List<Song> allSongs = songs.getSongs();

    // Get summary statistics on song years
    IntSummaryStatistics result = allSongs.stream()
            .mapToInt(Song::getYear)
            .sorted()
            .summaryStatistics();

    System.out.println("result = " + result);
  }

  // PRIMITIVE STREAMS
  // Calculate total plays for all versions of a specific song
  @Test
  void shouldBeAbleToCalculateCountForAllVersionsOfASong() {
    List<Song> allSongs = songs.getSongs();

    String songTitle = "Hurt";
    int result = allSongs.stream()
            .filter(song -> song.getTitle().equals(songTitle))
            .mapToInt(Song::getTimesPlayed)
            .sum();

    System.out.println("result = " + result);
  }
}
