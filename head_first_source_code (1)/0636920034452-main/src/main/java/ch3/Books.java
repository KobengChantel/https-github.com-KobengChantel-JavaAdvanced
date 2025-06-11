package ch3;

// This code defines a Books class and creates an array of three Books objects, assigns titles and authors to each, and then prints out the book details using a while loop.
class Books {
  String title;   // Title of the book
  String author;  // Author of the book
}

class BooksTestDrive {
  public static void main(String[] args) {
    Books[] myBooks = new Books[3];      // Create an array to hold 3 Books objects
    int x = 0;

    myBooks[0] = new Books();            // Initialize each element with a new Books object
    myBooks[1] = new Books();
    myBooks[2] = new Books();

    // Assign titles to each book
    myBooks[0].title = "The Grapes of Java";
    myBooks[1].title = "The Java Gatsby";
    myBooks[2].title = "The Java Cookbook";

    // Assign authors to each book
    myBooks[0].author = "bob";
    myBooks[1].author = "sue";
    myBooks[2].author = "ian";

    // Loop through the array and print out each book's title and author
    while (x < 3) {
      System.out.print(myBooks[x].title);
      System.out.print(" by ");
      System.out.println(myBooks[x].author);
      x = x + 1;
    }
  }
}
