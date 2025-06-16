package ch2;

// This code defines a StreamingSong class with song details and methods to play the song and print its info, then creates and uses a StreamingSong object in the main method.
class StreamingSong {
  String title;     // Title of the song
  String artist;    // Artist of the song
  int duration;     // Duration of the song (in seconds or minutes)

  void play() {
    System.out.println("Playing song");  // Simulate playing the song
  }

  void printDetails() {
    System.out.println("This is " + title +
            " by " + artist);  // Print the song's title and artist
  }
}

class StreamingSongTestDrive {
  public static void main(String[] args) {
    StreamingSong song = new StreamingSong();   // Create a new StreamingSong object
    song.artist = "The Beatles";                // Set the artist
    song.title = "Come Together";               // Set the title
    song.play();                                // Call the play method
    song.printDetails();                        // Print the song's details
  }
}
