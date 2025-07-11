package ch11;

import java.util.ArrayList;
import java.util.List;

// This class provides mock data by returning lists of SongV3 and SongV4 objects with some duplicate entries for testing purposes.

class MockMoreSongs {

  // Returns a list of SongV3 objects with song title, artist, and bpm, including duplicates
  public static List<SongV3> getSongsV3() {
    List<SongV3> songs = new ArrayList<>();
    songs.add(new SongV3("somersault", "zero 7", 147));
    songs.add(new SongV3("cassidy", "grateful dead", 158));
    songs.add(new SongV3("$10", "hitchhiker", 140));
    songs.add(new SongV3("havana", "cabello", 105));
    songs.add(new SongV3("$10", "hitchhiker", 140));
    songs.add(new SongV3("cassidy", "grateful dead", 158));
    songs.add(new SongV3("50 ways", "simon", 102));
    return songs;
  }

  // Returns a list of SongV4 objects with the same data as above for testing newer Song class versions
  public static List<SongV4> getSongsV4() {
    List<SongV4> songs = new ArrayList<>();
    songs.add(new SongV4("somersault", "zero 7", 147));
    songs.add(new SongV4("cassidy", "grateful dead", 158));
    songs.add(new SongV4("$10", "hitchhiker", 140));
    songs.add(new SongV4("havana", "cabello", 105));
    songs.add(new SongV4("$10", "hitchhiker", 140));
    songs.add(new SongV4("cassidy", "grateful dead", 158));
    songs.add(new SongV4("50 ways", "simon", 102));
    return songs;
  }
}

// "text file" version of the songs data as comments for reference
//somersault, zero 7, 50
//cassidy, grateful dead, 65
//$10, hitchhiker, 80
//havana, cabello, 60
//$10, hitchhiker, 80
//cassidy, grateful dead, 65
//50 ways, simon, 70
