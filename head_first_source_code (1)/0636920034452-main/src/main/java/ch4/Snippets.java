package ch4;

// This code defines classes to create and manage Song objects, perform simple method calls with parameters, and demonstrate how object references are compared in Java.

public class Snippets {
  void createSongs() {
    Song song1 = new Song();           // Create first Song object
    song1.setArtist("Travis");         // Set artist for song1
    song1.setTitle("Sing");            // Set title for song1
    Song song2 = new Song();           // Create second Song object
    song2.setArtist("Sex Pistols");    // Set artist for song2
    song2.setTitle("My Way");          // Set title for song2
  }

  void go() {
    TestStuff t = new TestStuff();     // Create TestStuff object
    t.takeTwo(12, 34);                 // Call method with two int parameters
  }

  void comparingVariables() {
    Foo a = new Foo();                 // Create Foo object a
    Foo b = new Foo();                 // Create Foo object b
    Foo c = a;                        // c references same object as a
    if (a == b) { // false because different objects
      if (a == c) { // true because same reference
        if (b == c) { // false different objects
        }
      }
    }
  }
}

class Song {
  private String artist;               // Artist name
  private String title;                // Song title

  public void setArtist(String artist) {
    this.artist = artist;              // Set artist
  }

  public String getArtist() {
    return artist;                    // Get artist
  }

  public void setTitle(String title) {
    this.title = title;               // Set title
  }

  public String getTitle() {
    return title;                     // Get title
  }
}

class TestStuff {
  void takeTwo(int x, int y) {
    int z = x + y;                    // Add two integers
    System.out.println("Total is " + z);  // Print sum
  }
}
