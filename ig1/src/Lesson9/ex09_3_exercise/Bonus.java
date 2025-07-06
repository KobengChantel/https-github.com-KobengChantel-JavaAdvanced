package Lesson9.ex09_3_exercise;

// This enum defines bonus percentages for different employee roles and provides a method to retrieve the percentage based on role.

public enum Bonus {

    // Bonus percentages per role
    STAFF(0.02),
    MANAGER(0.04),
    EXECUTIVE(0.06);

    // Field to store the bonus percentage
    private final double percent;

    // Constructor to initialize the bonus percentage
    Bonus(double percent){
        this.percent = percent;
    }

    // Getter method to retrieve the bonus percentage
    public double percent(){
        return percent;
    }

    // Static method that returns the bonus percentage based on the given role
    public static double byRole(Role r){
        double bonusPercent = 0.0d;

        // Determine the appropriate bonus based on the employee's role
        switch(r){
            case EXECUTIVE: bonusPercent = EXECUTIVE.percent; break;
            case MANAGER: bonusPercent = MANAGER.percent; break;
            case STAFF: bonusPercent = STAFF.percent; break;
        }

        return bonusPercent;
    }
}
