package Lesson9.ex09_4_exercise;

/**
 * Enum representing vacation accrual rates per day based on employee roles.
 */
public enum VacAccrual {

    STAFF((2 * 7) / 365d),        // 2 weeks of vacation per year converted to daily rate
    MANAGER((2.5 * 7) / 365d),    // 2.5 weeks per year converted to daily rate
    EXECUTIVE((3 * 7) / 365d);    // 3 weeks per year converted to daily rate

    private final double perDay;   // Vacation accrual rate per day

    /**
     * Constructor to set the accrual rate per day.
     * @param perDay daily accrual rate for vacation
     */
    VacAccrual(double perDay){
        this.perDay = perDay;
    }

    /**
     * Returns the vacation accrual rate per day.
     * @return vacation days accrued per day worked
     */
    public double perDay(){
        return perDay;
    }

    /**
     * Returns the vacation accrual rate per day for a given employee Role.
     * @param r employee role
     * @return vacation accrual rate per day for that role
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
