package ch11;

// Represents a song with title, artist, and bpm, and allows comparison by title for sorting.

class SongV3 implements Comparable<SongV3> {
  private String title;
  private String artist;
  private int bpm;

  // Compares this song to another based on the title alphabetically
  public int compareTo(SongV3 s) {
    return title.compareTo(s.getTitle());
  }

  // Constructor to initialize title, artist, and bpm
  SongV3(String title, String artist, int bpm) {
    this.title = title;
    this.artist = artist;
    this.bpm = bpm;
  }

  // Getter for title
  public String getTitle() {
    return title;
  }

  // Getter for artist
  public String getArtist() {
    return artist;
  }

  // Getter for bpm
  public int getBpm() {
    return bpm;
  }

  // Returns the song title when the object is printed
  public String toString() {
    return title;
  }
}
