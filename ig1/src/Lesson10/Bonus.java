package Lesson10;

/**
 * Enum representing different employee bonus percentages based on roles.
 */
public enum Bonus {

    // Enum constants with their respective bonus percentages
    STAFF(0.02),
    MANAGER(0.04),
    EXECUTIVE(0.06);

    // The bonus percentage value for each role
    private final double percent;

    // Constructor to initialize the bonus percentage
    Bonus(double percent){
        this.percent = percent;
    }

    // Getter method to retrieve the bonus percentage
    public double percent(){
        return percent;
    }

    /**
     * Returns the bonus percentage based on the given Role.
     * @param r Role enum value
     * @return bonus percentage for the role
     */
    public static double byRole(Role r){
        double bonusPercent = 0.0d;

        // Determine bonus percentage according to the role
        switch(r){
            case EXECUTIVE: bonusPercent = EXECUTIVE.percent; break;
            case MANAGER: bonusPercent = MANAGER.percent; break;
            case STAFF: bonusPercent = STAFF.percent; break;
        }

        return bonusPercent;
    }
}
