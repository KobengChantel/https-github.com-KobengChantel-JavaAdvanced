package ch11;

import java.util.*;

/**
 * This code demonstrates using a TreeSet with a custom Comparator to sort Book objects
 * by their title without requiring the Book class to implement Comparable.
 */
class BookCompare implements Comparator<Book> {
  // Compare two Book objects based on their title lexicographically
  public int compare(Book one, Book two) {
    return one.title.compareTo(two.title);
  }
}

public class TestTreeComparator {
  public static void main(String[] args) {
    new TestTreeComparator().go();
  }

  public void go() {
    // Create Book instances
    Book b1 = new Book("How Cats Work");
    Book b2 = new Book("Remix your Body");
    Book b3 = new Book("Finding Emo");

    // Create a BookCompare instance to define sorting order
    BookCompare bookCompare = new BookCompare();

    // Create a TreeSet that uses the custom comparator for sorting
    Set<Book> tree = new TreeSet<>(bookCompare);
    tree.add(b1);
    tree.add(b2);
    tree.add(b3);

    // Print the sorted set of books
    System.out.println(tree);
  }
}
