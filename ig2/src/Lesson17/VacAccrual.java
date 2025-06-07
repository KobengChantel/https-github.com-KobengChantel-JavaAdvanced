package Lesson17;

/**
 * Enum representing vacation accrual rates based on employee roles.
 * Calculates the daily vacation accrual rate as weeks of vacation per year divided by days in a year.
 *
 * @author MikeW
 */
public enum VacAccrual {

    // Enum constants with accrual rates (weeks of vacation per year converted to daily rate)
    STAFF((2 * 7) / 365d),       // Staff get 2 weeks vacation per year
    MANAGER((2.5 * 7) / 365d),   // Managers get 2.5 weeks vacation per year
    EXECUTIVE((3 * 7) / 365d);   // Executives get 3 weeks vacation per year

    // Daily vacation accrual rate
    private final double perDay;

    // Constructor to set the daily accrual rate
    VacAccrual(double perDay) {
        this.perDay = perDay;
    }

    // Getter method to access daily accrual rate
    public double perDay() {
        return perDay;
    }

    /**
     * Returns the vacation accrual rate per day based on the Role provided.
     *
     * @param r Role of the employee
     * @return accrual rate as double (vacation days accrued per day worked)
     */
    public static double byRole(Role r) {
        double accrualRate = 0.0d;

        // Select accrual rate based on role
        switch (r) {
            case EXECUTIVE: accrualRate = EXECUTIVE.perDay; break;
            case MANAGER: accrualRate = MANAGER.perDay; break;
            case STAFF: accrualRate = STAFF.perDay; break;
        }

        return accrualRate;
    }

}
