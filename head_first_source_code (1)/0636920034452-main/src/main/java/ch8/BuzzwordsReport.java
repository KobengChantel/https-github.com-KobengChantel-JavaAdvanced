package ch8;

// This class extends Report and overrides runReport to include additional behavior related to buzzword compliance.

class BuzzwordsReport extends Report {
  void runReport() {
    super.runReport();       // Call the runReport method from the parent Report class
    buzzwordCompliance();    // Call a method to check for buzzword compliance (currently empty)
    printReport();           // Call a method (likely from Report) to print the report
  }

  void buzzwordCompliance() {
    // Method stub for buzzword compliance logic (not yet implemented)
  }
}
