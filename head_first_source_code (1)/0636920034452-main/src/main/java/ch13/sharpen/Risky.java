package ch13.sharpen;

// This class demonstrates a method that explicitly throws a checked exception DeltaEx to signal a risky operation.

public class Risky {
  // Method that always throws a DeltaEx exception when called
  public void doRisky() throws DeltaEx {
    throw new DeltaEx();
  }
}
