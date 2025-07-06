package Lesson9.ex09_4_exercise;

/**
 * Enum representing bonus percentages for different employee roles.
 */
public enum Bonus {

    // Bonus percentages for each role
    STAFF(0.02),       // 2% bonus
    MANAGER(0.04),     // 4% bonus
    EXECUTIVE(0.06);   // 6% bonus

    private final double percent;  // Bonus percentage

    /**
     * Constructor to set the bonus percentage.
     * @param percent the bonus percentage for the role
     */
    Bonus(double percent){
        this.percent = percent;
    }

    /**
     * Getter for the bonus percentage.
     * @return bonus percent as a decimal
     */
    public double percent(){
        return percent;
    }

    /**
     * Returns the bonus percentage based on the employee Role.
     * @param r the Role
     * @return bonus percentage for the role
     */
    public static double byRole(Role r){

        double bonusPercent = 0.0d;

        switch(r){
            case EXECUTIVE: bonusPercent = EXECUTIVE.percent; break;
            case MANAGER: bonusPercent = MANAGER.percent; break;
            case STAFF: bonusPercent = STAFF.percent; break;
        }

        return bonusPercent;
    }

}
