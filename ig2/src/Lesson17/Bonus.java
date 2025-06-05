package Lesson17;

/**
 * Enum representing bonus percentages based on employee roles.
 * Each role is associated with a specific bonus percentage.
 * @author oracle
 */
public enum Bonus {

    // Define constants with associated bonus percentages
    STAFF(0.02),
    MANAGER(0.04),
    EXECUTIVE(0.06);

    // Field to store the bonus percentage for each role
    private final double percent;

    // Constructor to initialize the bonus percentage for each enum constant
    Bonus(double percent){
        this.percent = percent;
    }

    // Getter method to retrieve the bonus percentage
    public double percent(){
        return percent;
    }

    // Static method to get bonus percentage by Role enum value
    public static double byRole(Role r){

        double bonusPercent = 0.0d;

        // Assign bonusPercent based on the Role passed in
        switch(r){
            case EXECUTIVE: bonusPercent = EXECUTIVE.percent; break;
            case MANAGER: bonusPercent = MANAGER.percent; break;
            case STAFF: bonusPercent = STAFF.percent; break;
        }

        return bonusPercent;
    }
}
