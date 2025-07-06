package Lesson9.ex09_1_exercise;

// This enum defines bonus percentages based on employee roles and provides a method to retrieve the correct bonus based on a given role.

public enum Bonus {

    // Enum constants with associated bonus percentage values
    STAFF(0.02),
    MANAGER(0.04),
    EXECUTIVE(0.06);

    // Private field to store the bonus percentage for each role
    private final double percent;

    // Constructor to initialize the percentage for each enum constant
    Bonus(double percent){
        this.percent = percent;
    }

    // Getter method to retrieve the bonus percentage
    public double percent(){
        return percent;
    }

    // Static method to return the bonus percentage based on a given role
    public static double byRole(Role r){
        double bonusPercent = 0.0d;

        // Determine the bonus percentage based on the role using a switch statement
        switch(r){
            case EXECUTIVE: bonusPercent = EXECUTIVE.percent; break;
            case MANAGER: bonusPercent = MANAGER.percent; break;
            case STAFF: bonusPercent = STAFF.percent; break;
        }

        return bonusPercent;
    }
}
