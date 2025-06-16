package ch11;

// Represents a song with title, artist, and bpm, supports comparison by title,
// and overrides equals and hashCode based on the title for proper collection behavior.

class SongV4 implements Comparable<SongV4> {
  private String title;
  private String artist;
  private int bpm;

  // Checks equality by comparing song titles
  public boolean equals(Object aSong) {
    SongV4 other = (SongV4) aSong;
    return title.equals(other.getTitle());
  }

  // Returns hash code based on title to maintain contract with equals
  public int hashCode() {
    return title.hashCode();
  }

  // Compares this song to another by title for sorting
  public int compareTo(SongV4 s) {
    return title.compareTo(s.getTitle());
  }

  // Constructor to initialize title, artist, and bpm
  SongV4(String title, String artist, int bpm) {
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

  // Returns the song title as string representation
  public String toString() {
    return title;
  }
}
