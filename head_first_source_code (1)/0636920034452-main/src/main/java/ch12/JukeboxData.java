package ch12;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.*;

// This class demonstrates how to use Java Streams to analyze a list of songs and extract genre information such as unique genres and genre frequency.
public class JukeboxData {

  // Inner class containing a list of sample songs
  public static class Songs {

    // Returns a hardcoded list of Song objects with details like title, artist, genre, year, and duration
    public List<Song> getSongs() {
      return List.of(
              new Song("$10", "Hitchhiker", "Electronic", 2016, 183),
              new Song("Havana", "Camila Cabello", "R&B", 2017, 324),
              new Song("Cassidy", "Grateful Dead", "Rock", 1972, 123),
              new Song("50 ways", "Paul Simon", "Soft Rock", 1975, 199),
              new Song("Hurt", "Nine Inch Nails", "Industrial Rock", 1995, 257),
              new Song("Silence", "Delerium", "Electronic", 1999, 134),
              new Song("Hurt", "Johnny Cash", "Soft Rock", 2002, 392),
              new Song("Watercolour", "Pendulum", "Electronic", 2010, 155),
              new Song("The Outsider", "A Perfect Circle", "Alternative Rock", 2004, 312),
              new Song("With a Little Help from My Friends", "The Beatles", "Rock", 1967, 168),
              new Song("Come Together", "The Beatles", "Blues rock", 1968, 173),
              new Song("Come Together", "Ike & Tina Turner", "Rock", 1970, 165),
              new Song("With a Little Help from My Friends", "Joe Cocker", "Rock", 1968, 46),
              new Song("Immigrant Song", "Karen O", "Industrial Rock", 2011, 12),
              new Song("Breathe", "The Prodigy", "Electronic", 1996, 337),
              new Song("What's Going On", "Gaye", "R&B", 1971, 420),
              new Song("Hallucinate", "Dua Lipa", "Pop", 2020, 75),
              new Song("Walk Me Home", "P!nk", "Pop", 2019, 459),
              new Song("I am not a woman, I'm a god", "Halsey", "Alternative Rock", 2021, 384),
              new Song("Pasos de cero", "Pablo Alborán", "Latin", 2014, 117),
              new Song("Smooth", "Santana", "Latin", 1999, 244),
              new Song("Immigrant song", "Led Zeppelin", "Rock", 1970, 484));
    }
  }

  public static void main(String[] args) {
    Songs songs = new Songs(); // create instance to access the song list
    List<Song> songList = songs.getSongs(); // retrieve list of songs

    // Extract a list of distinct genres from all songs
    List<String> genres = songList.stream()
            .map(song -> song.getGenre()) // get genre of each song
            .distinct() // keep only unique genres
            .collect(toList()); // collect into a list
    System.out.println("genres = " + genres);

    // Print how many distinct genres are in the list
    System.out.println(songList.stream()
            .map(song -> song.getGenre())
            .distinct()
            .count());

    // Create a map where the key is the genre and the value is how many times it appears
    Map<String, Long> genreCount = songList.stream()
            .map(song -> song.getGenre())
            .collect(groupingBy(Function.identity(), counting()));
    System.out.println("genreCount = " + genreCount);
  }

}
