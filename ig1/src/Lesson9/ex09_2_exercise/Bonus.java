package Lesson9.ex09_2_exercise;

// This enum defines bonus percentages for STAFF, MANAGER, and EXECUTIVE roles and includes a method to retrieve the bonus by role.

public enum Bonus {

    // Enum constants with corresponding bonus percentages
    STAFF(0.02),
    MANAGER(0.04),
    EXECUTIVE(0.06);

    // Private field to store the bonus percentage
    private final double percent;

    // Constructor to assign the bonus percentage
    Bonus(double percent){
        this.percent = percent;
    }

    // Getter method to retrieve the bonus percentage
    public double percent(){
        return percent;
    }

    // Static method that returns the bonus percentage based on the Role
    public static double byRole(Role r){
        double bonusPercent = 0.0d;

        // Determine bonus percentage using a switch-case based on the role
        switch(r){
            case EXECUTIVE: bonusPercent = EXECUTIVE.percent; break;
            case MANAGER: bonusPercent = MANAGER.percent; break;
            case STAFF: bonusPercent = STAFF.percent; break;
        }

        return bonusPercent;
    }
}
