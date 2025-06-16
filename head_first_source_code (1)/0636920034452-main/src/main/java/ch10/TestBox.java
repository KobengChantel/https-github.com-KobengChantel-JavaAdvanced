package ch10;

public class TestBox {
  // Integer object reference (wrapper class for int), initially null
  private Integer i;

  // Primitive int variable, default to 0
  private int j;

  public static void main(String[] args) {
    TestBox t = new TestBox();  // create instance of TestBox
    t.go();                     // call go method
  }

  public void go() {
    // Assign Integer i to primitive int j: unboxing happens here.
    // Since i is null by default (not initialized), this causes a NullPointerException at runtime.
    j = i;

    // Print primitive int j
    System.out.println(j);

    // Print Integer i (will print null if no exception occurred)
    System.out.println(i);
  }
}
