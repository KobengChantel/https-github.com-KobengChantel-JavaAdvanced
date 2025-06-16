package ch10;

public class Song {
  // Instance variable to hold the song's title
  String title;

  // Constructor to initialize the Song with a title
  public Song(String t) {
    title = t;
  }

  // Method to play the song by delegating to SoundPlayer
  public void play() {
    SoundPlayer player = new SoundPlayer();  // create a SoundPlayer instance
    player.playSound(title);                  // play the sound using the song's title
  }
}

// Separate class responsible for playing sounds
class SoundPlayer {
  // Method stub to play a sound given a title (implementation missing)
  public void playSound(String title) {
    // Implementation would play the audio for the given title
  }
}
