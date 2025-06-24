package Lesson4.ex04_3_exercise;

// This program demonstrates the Singleton pattern by accessing the same PeerSingleton instance from two variables.

public class Main {
  public static void main(String[] args) {
    // Get the single instance of PeerSingleton
    PeerSingleton peer01 = PeerSingleton.getInstance();
    PeerSingleton peer02 = PeerSingleton.getInstance();

    // Print host names from the first reference
    for (String hostName : peer01.getHostNames()) {
      System.out.println("Host Name: " + hostName);
    }

    System.out.println();

    // Print host names again from the second reference (same instance)
    for (String hostName : peer02.getHostNames()) {
      System.out.println("Host Name: " + hostName);
    }
  }
}
