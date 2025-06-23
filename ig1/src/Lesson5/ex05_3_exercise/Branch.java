package Lesson5.ex05_3_exercise;

// Enum representing different bank branches, each with an associated service level description.

public enum Branch {
    LA("Basic"),           // Los Angeles branch with Basic service
    BOSTON("Loan"),        // Boston branch with Loan service
    BANGALORE("Full"),     // Bangalore branch with Full service
    MUMBAI("Full");        // Mumbai branch with Full service

    String serviceLevel;    // Describes the service level offered by the branch

    // Constructor to set the service level for each branch constant
    private Branch(String serviceLevel) {
        this.serviceLevel = serviceLevel;
    }

    // Getter to retrieve the service level of the branch
    public String getServiceLevel() {
        return serviceLevel;
    }
}
