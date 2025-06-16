package ch8;

// The abstract Report class provides a basic structure for generating and printing reports.

abstract class Report {

  // Method to handle report setup logic (to be possibly extended by subclasses)
  void runReport() {
    // set-up report (e.g., gather data, initialize settings)
  }

  // Method to handle generic printing of the report
  void printReport() {
    // generic printing (e.g., formatting and output)
  }
}
