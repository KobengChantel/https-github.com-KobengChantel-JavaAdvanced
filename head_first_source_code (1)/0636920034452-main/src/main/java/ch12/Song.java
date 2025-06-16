package ch12;

// This class represents a song with details such as title, artist, genre, release year, and number of times played.

public class Song {
  // Song title
  private final String title;

  // Name of the artist who performed the song
  private final String artist;

  // Genre of the song (e.g., Rock, Pop)
  private final String genre;

  // Year the song was released
  private final int year;

  // How many times the song has been played
  private final int timesPlayed;

  // Constructor to initialize all fields of the Song object
  public Song(String title, String artist, String genre, int year, int timesPlayed) {
    this.title = title;
    this.artist = artist;
    this.genre = genre;
    this.year = year;
    this.timesPlayed = timesPlayed;
  }

  // Getter for timesPlayed
  public int getTimesPlayed() {
    return timesPlayed;
  }

  // Getter for title
  public String getTitle() {
    return title;
  }

  // Getter for artist
  public String getArtist() {
    return artist;
  }

  // Getter for genre
  public String getGenre() {
    return genre;
  }

  // Getter for year
  public int getYear() {
    return year;
  }

  // Custom toString method to return song details in a readable format
  @Override
  public String toString() {
    return title + ", "
            + artist + ", "
            + genre + ", "
            + year + ", "
            + timesPlayed + "\n";
  }
}
