package appB;

// This code defines an enum BandMember with specific instruments and custom singing behaviors for some members, and then prints out each member's name, instrument, and how they sing.

public class HfjEnum {
  enum BandMember {
    // Enum constants with overridden sings() method for KEVIN and BOB
    KEVIN("lead guitar") {
      public String sings() {
        return "plaintively";
      }
    },
    BOB("rhythm guitar") {
      public String sings() {
        return "hoarsely";
      }
    },
    // STUART uses the default sings() method
    STUART("bass");

    private final String instrument;

    // Constructor to set the instrument for each band member
    BandMember(String instrument) {
      this.instrument = instrument;
    }

    // Getter for the instrument
    public String getInstrument() {
      return this.instrument;
    }

    // Default implementation of sings()
    public String sings() {
      return "occasionally";
    }
  }

  public static void main(String[] args) {
    // Loop through all band members and print their info
    for (BandMember bandMember : BandMember.values()) {
      System.out.print(bandMember);
      System.out.print(", instrument: " + bandMember.getInstrument());
      System.out.println(", sings: " + bandMember.sings());
    }
  }
}
