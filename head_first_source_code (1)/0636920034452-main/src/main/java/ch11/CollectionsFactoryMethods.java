package ch11;

import java.util.*;

// This program demonstrates how to create unmodifiable collections (List, Set, Map) using Java's factory methods introduced in Java 9.

public class CollectionsFactoryMethods {
  public static void main(String[] args) {
    createAListOfSongs(); // Calls the method to create a list of SongV4 objects
  }

  // Creates a List using the "old-school" method and makes it unmodifiable
  public static List<String> createAListOldSchool() {
    List<String> songs = new ArrayList<>();
    songs.add("somersault");
    songs.add("cassidy");
    songs.add("$10");
    return Collections.unmodifiableList(songs); // Makes the list unmodifiable
  }

  // Creates an unmodifiable List of Strings using List.of()
  public static void createAList() {
    List<String> strings = List.of("somersault", "cassidy", "$10");
  }

  // Creates an unmodifiable List of SongV4 objects using List.of()
  public static void createAListOfSongs() {
    List<SongV4> songs = List.of(new SongV4("somersault", "zero 7", 147),
            new SongV4("cassidy", "grateful dead", 158),
            new SongV4("$10", "hitchhiker", 140));
  }

  // Creates an unmodifiable Set of Book objects using Set.of()
  public static void createASet() {
    Set<Book> books = Set.of(new Book("How Cats Work"),
            new Book("Remix your Body"),
            new Book("Finding Emo"));
  }

  // Creates an unmodifiable Map with String keys and Integer values using Map.of()
  public static void createAMap() {
    Map<String, Integer> scores = Map.of("Kathy", 42,
            "Bert", 343,
            "Skyler", 420);
  }

  // Creates an unmodifiable Map with String keys and String values using Map.of()
  public static void createAMapOfSameTypes() {
    Map<String, String> favouriteStores = Map.of("Riley", "Supersports",
            "Brooklyn", "Camera World",
            "Jay", "Homecase");
  }

  // Creates an unmodifiable Map using Map.ofEntries() with Map.entry() pairs
  public static void createAMapOfEntries() {
    Map<String, String> favouriteStores = Map.ofEntries(Map.entry("Riley", "Supersports"),
            Map.entry("Brooklyn", "Camera World"),
            Map.entry("Jay", "Homecase"));
  }

}
