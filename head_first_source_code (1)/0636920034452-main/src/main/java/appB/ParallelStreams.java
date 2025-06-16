package appB;

import ch12.JukeboxData;
import ch12.Song;

import java.util.List;
import java.util.stream.Stream;

// This code demonstrates two ways to create and use parallel streams in Java for processing collections concurrently.
public class ParallelStreams {
  // Creates a parallel stream directly from a list of Song objects
  void startAParallelStream() {
    List<Song> songs = new JukeboxData.Songs().getSongs();

    // Obtains a parallel stream from the songs list
    Stream<Song> songStream = songs.parallelStream();
  }

  // Converts a sequential stream into a parallel stream
  void addAParallelOperationStream() {
    List<Song> songs = new JukeboxData.Songs().getSongs();

    // Creates a sequential stream and then switches it to parallel
    Stream<Song> songStream = songs.stream()
            .parallel();
  }
}
