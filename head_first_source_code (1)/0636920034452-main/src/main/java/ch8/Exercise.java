package ch8;

// This Exercise class demonstrates various combinations of class and interface inheritance structures.

public class Exercise {

  // Define an interface named Foo
  public interface Foo { }

  // Bar is a class that implements the Foo interface
  public class Bar implements Foo { }

  // Define an interface named Vinn
  public interface Vinn { }

  // Vout is an abstract class that implements the Vinn interface
  public abstract class Vout implements Vinn { }

  // Muffie is an abstract class that implements the Whuffie interface
  public abstract class Muffie implements Whuffie { }

  // Fluffie is a concrete class that extends the abstract Muffie class
  public class Fluffie extends Muffie { }

  // Define an interface named Whuffie
  public interface Whuffie { }

  // Zoop is a base class
  public class Zoop { }

  // Boop is a subclass of Zoop
  public class Boop extends Zoop { }

  // Goop is a subclass of Boop (making it a multilevel inheritance from Zoop)
  public class Goop extends Boop { }

  // Gamma is a subclass of Delta and implements the Epsilon interface
  public class Gamma extends Delta implements Epsilon { }

  // Define the Epsilon interface
  public interface Epsilon { }

  // Define another interface named Beta
  public interface Beta { }

  // Alpha is a subclass of Gamma and implements the Beta interface
  public class Alpha extends Gamma implements Beta { }

  // Define the Delta class, which Gamma extends
  public class Delta { }
}
