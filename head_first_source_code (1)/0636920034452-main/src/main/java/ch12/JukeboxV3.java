package ch12;

import java.util.ArrayList;
import java.util.Collections;

// This class simulates a jukebox that tracks how many times each song was played and displays songs sorted by least played.
public class JukeboxV3 {

  ArrayList<SongV3> songList = new ArrayList<>();  // stores the list of available songs
  ArrayList<Log> logList = new ArrayList<>();      // stores the play logs of songs

  public static void main(String[] args) {
    new JukeboxV3().go();  // run the program
  }

  public void go() {
    // retrieve the song and log data (mocked in SongV3 and Log classes)
    songList = new SongV3().getSongsV3();
    logList = new Log().getLog();

    ArrayList<Result> tempList = new ArrayList<>();

    // initialize results with all songs, play count starts at 0
    for (SongV3 s : songList) {
      tempList.add(new Result(s.id, 0));
    }

    // iterate over logs and count how many times each song (by ID) was played
    for (Log l : logList) {
      for (Result r : tempList) {
        if (l.id == r.id) {
          ++r.count;
        }
      }
    }

    // sort the results by play count in ascending order (least played first)
    Collections.sort(tempList,
            (s1, s2) -> s1.getCount().compareTo(s2.getCount()));

    // print the sorted result
    System.out.println("\n\n" + tempList);
  }
}

// Class to hold each song's ID and play count for comparison and sorting
class Result {
  int id;
  Integer count;  // Integer is used instead of int for use in sorting

  Result(int i, int c) {
    id = i;
    count = c;
  }

  Integer getCount() {
    return count;
  }

  public String toString() {
    return(id + " " + count);
  }
}

// Represents a song with basic metadata like title, band, genre, etc.
class SongV3 {
  int id;
  String title;
  String band;
  String genre;
  int year;

  SongV3() {}

  SongV3(int id, String title, String band, String genre, int year) {
    this.id = id;
    this.title = title;
    this.band = band;
    this.genre = genre;
    this.year = year;
  }

  // Returns a hardcoded list of songs
  public ArrayList<SongV3> getSongsV3() {
    ArrayList<SongV3> mySongs = new ArrayList<>();
    mySongs.add(new SongV3(1, "Cassidy", "Grateful Dead", "Rock", 1972));
    mySongs.add(new SongV3(2, "Crazy Diamond", "Pink Floyd", "Rock", 1975));
    mySongs.add(new SongV3(3, "Rosen Im Asphalt", "Schnauss", "Electronic", 2017));
    mySongs.add(new SongV3(4, "Havana", "Cabillo", "R&B", 2017));
    mySongs.add(new SongV3(5, "Take Five", "Brubeck", "Jazz", 1959));
    mySongs.add(new SongV3(6, "Jumpin' Jack Flash", "Stones", "rock", 1964));
    mySongs.add(new SongV3(7, "Silence", "Delerium", "Trance", 1999));
    mySongs.add(new SongV3(8, "Lochs of Dread", "Strength in Numbers", "Newgrass", 1989));
    mySongs.add(new SongV3(9, "No Woman No Cry", "Marley", "Reggae", 1974));
    mySongs.add(new SongV3(10, "If I Ain't Got You", "Keys", "R&B", 2003));
    mySongs.add(new SongV3(11, "Don't Know Why", "Jones", "Jazz", 2002));
    mySongs.add(new SongV3(12, "Smooth", "Santana", "Rock", 1999));
    mySongs.add(new SongV3(13, "Come Together", "Beatles", "Rock", 1969));
    mySongs.add(new SongV3(14, "Love on a Real Train", "Tangerine Dream", "Electronic", 1984));
    mySongs.add(new SongV3(15, "Smoothie Song, Live", "Nickel Creek", "Newgrass", 2021));
    mySongs.add(new SongV3(16, "Switch Up", "Protoje", "Reggae", 2020));
    mySongs.add(new SongV3(17, "Stomp and Buck Dance", "Crusaders", "Jazz", 1974));
    mySongs.add(new SongV3(18, "Nature's Kingdom", "Delerium", "Trance", 2000));
    mySongs.add(new SongV3(19, "Eyes of the World", "Grateful Dead", "Rock", 1973));
    mySongs.add(new SongV3(20, "Midnight Train to Georgia", "Knight", "R&B", 1976));
    mySongs.add(new SongV3(21, "Black Clouds", "String Cheese", "Newgrass", 1997));
    mySongs.add(new SongV3(22, "What's Going On", "Gaye", "R&B", 1971));
    return mySongs;
  }

  public int getId() { return id; }
  public String getTitle() { return title; }
  public String getBand() { return band; }
  public String getGenre() { return genre; }
  public int getYear() { return year; }

  public String toString() {
    return(id + ": " + title + ", " + band + ", " + genre + ", " + year + "\n");
  }
}

// Represents a log entry of a song being played, storing its ID and date
class Log {
  int id;
  String date;

  Log(int id, String date) {
    this.id = id;
    this.date = date;
  }

  Log() {}

  public int getId() {
    return id;
  }

  public String toString() {
    return("" + id);
  }

  // Returns a hardcoded list of logs simulating songs played on a specific date
  public ArrayList<Log> getLog() {
    ArrayList<Log> myLog = new ArrayList<>();
    myLog.add(new Log(1, "2021-06-01"));
    myLog.add(new Log(8, "2021-06-01"));
    myLog.add(new Log(9, "2021-06-01"));
    myLog.add(new Log(18, "2021-06-01"));
    myLog.add(new Log(15, "2021-06-01"));
    myLog.add(new Log(13, "2021-06-01"));
    myLog.add(new Log(2, "2021-06-01"));
    myLog.add(new Log(5, "2021-06-01"));
    myLog.add(new Log(11, "2021-06-01"));
    myLog.add(new Log(4, "2021-06-01"));
    myLog.add(new Log(2, "2021-06-01"));
    myLog.add(new Log(8, "2021-06-01"));
    myLog.add(new Log(15, "2021-06-01"));
    myLog.add(new Log(6, "2021-06-01"));
    myLog.add(new Log(7, "2021-06-01"));
    myLog.add(new Log(1, "2021-06-01"));
    myLog.add(new Log(11, "2021-06-01"));
    myLog.add(new Log(4, "2021-06-01"));
    myLog.add(new Log(12, "2021-06-01"));
    myLog.add(new Log(21, "2021-06-01"));
    myLog.add(new Log(20, "2021-06-01"));
    myLog.add(new Log(14, "2021-06-01"));
    myLog.add(new Log(6, "2021-06-01"));
    myLog.add(new Log(4, "2021-06-01"));
    myLog.add(new Log(17, "2021-06-01"));
    myLog.add(new Log(18, "2021-06-01"));
    myLog.add(new Log(19, "2021-06-01"));
    myLog.add(new Log(21, "2021-06-01"));
    myLog.add(new Log(5, "2021-06-01"));
    myLog.add(new Log(9, "2021-06-01"));
    myLog.add(new Log(12, "2021-06-01"));
    myLog.add(new Log(10, "2021-06-01"));
    return myLog;
  }
}
