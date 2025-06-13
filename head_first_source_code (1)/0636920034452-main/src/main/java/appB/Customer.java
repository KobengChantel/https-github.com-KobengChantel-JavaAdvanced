package appB;

// This record defines an immutable data class named Customer with two components: id and name.
// Records were introduced in Java 16 to provide a compact syntax for classes that are simple data carriers.
// Using 'record' automatically generates constructor, getters, equals(), hashCode(), and toString() methods.
// Recommended to use Java 17 or higher since it is the current Long-Term Support (LTS) version.
public record Customer(int id, String name) { }
