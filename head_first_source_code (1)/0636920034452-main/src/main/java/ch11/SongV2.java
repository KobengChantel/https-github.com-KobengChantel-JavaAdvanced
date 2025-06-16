package ch11;

// Represents a song with a title, artist, and beats per minute (BPM).
class SongV2 {
  // Title of the song
  private String title;
  // Artist who performed the song
  private String artist;
  // Beats per minute (tempo) of the song
  private int bpm;

  // Constructor to initialize the song's title, artist, and bpm
  SongV2(String title, String artist, int bpm) {
    this.title = title;
    this.artist = artist;
    this.bpm = bpm;
  }

  // Getter method for title
  public String getTitle() {
    return title;
  }

  // Getter method for artist
  public String getArtist() {
    return artist;
  }

  // Getter method for bpm
  public int getBpm() {
    return bpm;
  }

  // Override toString method to return the song's title when printed
  public String toString() {
    return title;
  }
}
