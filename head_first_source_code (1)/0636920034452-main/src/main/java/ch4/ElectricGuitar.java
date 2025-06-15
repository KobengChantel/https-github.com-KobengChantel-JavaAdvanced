package ch4;

// This class models an ElectricGuitar with private-like fields and provides getter and setter methods to access and modify its brand, number of pickups, and whether a rock star uses it.

class ElectricGuitar {
  String brand;               // Brand name of the guitar
  int numOfPickups;           // Number of pickups on the guitar
  boolean rockStarUsesIt;     // Indicates if a famous rock star uses this guitar

  String getBrand() {         // Returns the brand of the guitar
    return brand;
  }

  void setBrand(String aBrand) {  // Sets the brand of the guitar
    brand = aBrand;
  }

  int getNumOfPickups() {         // Returns the number of pickups
    return numOfPickups;
  }

  void setNumOfPickups(int num) { // Sets the number of pickups
    numOfPickups = num;
  }

  boolean getRockStarUsesIt() {    // Returns whether a rock star uses this guitar
    return rockStarUsesIt;
  }

  void setRockStarUsesIt(boolean yesOrNo) { // Sets if a rock star uses this guitar
    rockStarUsesIt = yesOrNo;
  }
}
