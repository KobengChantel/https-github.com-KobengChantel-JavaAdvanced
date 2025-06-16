package appB;

// This code defines an enum representing band members and demonstrates how to compare enum values using if statements and a switch-case, highlighting the importance of break statements to avoid fall-through.

public enum Member {KEVIN, BOB, STUART}

class SomeClass {
  public Member selectedBandMember;

  // Example method that checks if the selected band member is KEVIN
  void someMethod() {
    if (selectedBandMember == Member.KEVIN) {
      // do KEVIN-related stuff
    }
  }

  // Static method showing how to compare enums using equals, ==, and switch-case
  static void doComparisons(Member member) {
    if (member.equals(Member.KEVIN))
      System.out.println("Bellloooo!");
    if (member == Member.BOB)
      System.out.println("Poochy");

    // Switch statement without breaks causes fall-through, printing all cases from matched onward
    switch (member) {
      case KEVIN: System.out.print("Uh... la cucaracha?");
      case BOB: System.out.println("King Bob");
      case STUART: System.out.print("Banana!");
    }
  }

  public static void main(String[] args) {
    doComparisons(Member.BOB);
  }
}
