package Lesson9.ex09_3_exercise;

/**
 * Enum representing vacation accrual rates per day for different employee roles.
 */
public enum VacAccrual {

    // Vacation accrual rates calculated as weeks of vacation converted to days per year divided by 365 days
    STAFF((2*7)/365d),       // 2 weeks of vacation per year
    MANAGER((2.5*7)/365d),   // 2.5 weeks of vacation per year
    EXECUTIVE((3*7)/365d);   // 3 weeks of vacation per year

    private final double perDay;  // Accrual rate per day

    /**
     * Constructor to set the accrual rate per day.
     * @param perDay vacation days accrued per day worked
     */
    VacAccrual(double perDay){
        this.perDay = perDay;
    }

    /**
     * Getter for the daily vacation accrual rate.
     * @return vacation days accrued per day
     */
    public double perDay(){
        return perDay;
    }

    /**
     * Returns the vacation accrual rate per day based on the given Role.
     * @param r the Role of the employee
     * @return accrual rate per day for that role
     */
    public static double byRole(Role r){
        double accrualRate = 0.0d;

        switch(r){
            case EXECUTIVE: accrualRate = EXECUTIVE.perDay; break;
            case MANAGER: accrualRate = MANAGER.perDay; break;
            case STAFF: accrualRate = STAFF.perDay; break;
        }

        return accrualRate;
    }

}
