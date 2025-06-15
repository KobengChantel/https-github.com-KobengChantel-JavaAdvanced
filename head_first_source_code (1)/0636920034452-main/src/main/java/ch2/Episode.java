package ch2;

// This code defines an Episode class with attributes and methods to simulate playing an episode and skipping parts, then creates an Episode object and demonstrates these actions.
class Episode {
  int seriesNumber;    // Number of the series the episode belongs to
  int episodeNumber;   // Number of the episode within the series

  void play() {
    System.out.println("Playing episode " + episodeNumber);  // Print that the episode is playing, showing its episode number
  }

  void skipIntro() {
    System.out.println("Skipping intro...");  // Print skipping the intro message
  }

  void skipToNext() {
    System.out.println("Loading next episode...");  // Print loading the next episode message
  }
}

class EpisodeTestDrive {
  public static void main(String[] args) {
    Episode episode = new Episode();  // Create a new Episode object
    episode.seriesNumber = 4;         // Set the series number to 4
    episode.play();                   // Call the play method
    episode.skipIntro();              // Call the skipIntro method
  }
}
