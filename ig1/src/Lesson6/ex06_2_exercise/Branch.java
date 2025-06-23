package Lesson6.ex06_2_exercise;

// Enum representing bank branches, each with an associated service level.

public enum Branch {
    LA("Basic"),           // Los Angeles branch with Basic service level
    Boston("Loan"),        // Boston branch with Loan service level
    Bangalore("Full"),     // Bangalore branch with Full service level
    Mumbai("Full");        // Mumbai branch with Full service level

    String serviceLevel;    // Description of the branch's service level

    // Constructor to set the service level for each branch
    private Branch(String serviceLevel) {
        this.serviceLevel = serviceLevel;
    }

    // Getter to retrieve the branch's service level
    public String getServiceLevel() {
        return serviceLevel;
    }
}
