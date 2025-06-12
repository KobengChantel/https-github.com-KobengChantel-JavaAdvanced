package ch4;

// This code defines a Clock class with methods to set and get the time, and demonstrates its use by creating a Clock object, setting a time, and printing it.

class Clock {
  String time;           // Instance variable to store the time as a String

  void setTime(String t) {  // Method to set the time
    time = t;
  }

  String getTime() {        // Method to retrieve the current time
    return time;
  }
}

class ClockTestDrive {
  public static void main(String[] args) {
    Clock c = new Clock();       // Create a new Clock object
    c.setTime("1245");           // Set time to "1245"
    String tod = c.getTime();    // Get the current time from the Clock object
    System.out.println("time: " + tod);  // Print the time
  }
}
