package ch3;

// This program creates an array of Triangle objects, calculates their areas, demonstrates object reference behavior, and shows how changes to one reference affect others pointing to the same object.

class Triangle {
  double area;    // Stores the area of the triangle
  int height;     // Height of the triangle
  int length;     // Base length of the triangle

  public static void main(String[] args) {
    int x = 0;
    Triangle[] ta = new Triangle[4];   // Array to hold 4 Triangle objects

    // Loop to create each Triangle, set height and length, calculate area, and print it
    while (x < 4) {
      ta[x] = new Triangle();           // Instantiate a new Triangle object
      ta[x].height = (x + 1) * 2;       // Set height based on index
      ta[x].length = x + 4;             // Set length based on index
      ta[x].setArea();                  // Calculate area and assign to the area field
      System.out.print("triangle " + x + ", area");
      System.out.println(" = " + ta[x].area);
      x = x + 1;
    }

    int y = x;                         // Store the value of x (which is 4)
    x = 27;                           // Change x to 27, no effect on triangles

    Triangle t5 = ta[2];              // t5 references the same Triangle as ta[2]
    ta[2].area = 343;                 // Modify the area of the triangle at index 2

    // Print y and area of t5, showing that modifying ta[2] also changes t5 because they reference the same object
    System.out.print("y = " + y);
    System.out.println(", t5 area = " + t5.area);
  }

  // Method to calculate and set the area of the triangle
  void setArea() {
    area = (height * length) / 2;
  }
}
