package ch12;

import java.util.List; // Imports the List interface from the java.util package.
import java.util.stream.Collectors; // Imports Collectors utility class to help collect stream elements into a list.

/*
This program filters and prints a list of rock genre songs from a collection using Java Streams.
*/

public class JukeboxStreams {
  public static void main(String[] args) {
    // Retrieves the list of songs from the Songs class
    List<Song> songs = new Songs().getSongs();

    // Filters songs that contain "Rock" in their genre and collects them into a new list
    List<Song> rockSongs = songs.stream()
            .filter(song -> song.getGenre().contains("Rock"))
            .collect(Collectors.toList());

    // Prints the list of filtered rock songs
    System.out.println(rockSongs);
  }
}

class Songs {
  public List<Song> getSongs() {
    // Returns a fixed list of Song objects with various genres and details
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
            new Song("Immigrant song", "Led Zeppelin", "Rock", 1970, 484)
    );
  }
}
