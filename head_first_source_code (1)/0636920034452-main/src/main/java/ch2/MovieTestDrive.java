package ch2;

// This code defines a Movie class with attributes and a method to simulate playing a movie, then creates three Movie objects with different details and calls their playIt method.
class Movie {
  String title;   // Movie title
  String genre;   // Movie genre
  int rating;     // Movie rating

  void playIt() {
    System.out.println("Playing the movie");  // Simulate playing the movie
  }
}

public class MovieTestDrive {
  public static void main(String[] args) {
    Movie one = new Movie();          // Create first Movie object
    one.title = "Gone with the Stock";
    one.genre = "Tragic";
    one.rating = -2;
    one.playIt();                    // Call playIt for first movie

    Movie two = new Movie();          // Create second Movie object
    two.title = "Lost in Cubicle Space";
    two.genre = "Comedy";
    two.rating = 5;
    two.playIt();                    // Call playIt for second movie

    Movie three = new Movie();        // Create third Movie object
    three.title = "Byte Club";
    three.genre = "Tragic but ultimately uplifting";
    three.rating = 127;
    three.playIt();                  // Call playIt for third movie
  }
}
