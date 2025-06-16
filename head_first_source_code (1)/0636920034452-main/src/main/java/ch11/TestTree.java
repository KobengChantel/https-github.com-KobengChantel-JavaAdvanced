package ch11;

import java.util.*;

/**
 * This code demonstrates the use of a TreeSet to store and automatically sort
 * Book objects based on their titles by implementing the Comparable interface.
 */
public class TestTree {
  public static void main(String[] args) {
    new TestTree().go();
  }

  public void go() {
    // Create some Book objects with different titles
    Book b1 = new Book("How Cats Work");
    Book b2 = new Book("Remix your Body");
    Book b3 = new Book("Finding Emo");

    // Create a TreeSet to hold Book objects; it sorts elements based on compareTo method
    Set<Book> tree = new TreeSet<>();
    tree.add(b1);
    tree.add(b2);
    tree.add(b3);

    // Print the sorted set of books
    System.out.println(tree);
  }
}

class Book implements Comparable<Book> {
  String title;

  public Book(String t) {
    title = t;
  }

  // Compare books by title lexicographically for sorting in TreeSet
  public int compareTo(Book other) {
    return title.compareTo(other.title);
  }

  // Provide a readable string representation of the Book object
  //Returns a string representation of the Book object in the format:
  //Book{title='the book's title'}
  public String toString() {
    return "Book{" +
            "title='" + title + '\'' + //// Append the title field with single quote escaped
            '}';
  }
}
