package Lesson9.ex09_1_exercise;

// This enum defines the daily vacation accrual rates for different employee roles and provides a method to retrieve the rate by role.

public enum VacAccrual {

    // Enum constants with vacation accrual formulas (days per year converted to per-day rate)
    STAFF((2 * 7) / 365d),         // 2 weeks/year for staff
    MANAGER((2.5 * 7) / 365d),     // 2.5 weeks/year for managers
    EXECUTIVE((3 * 7) / 365d);     // 3 weeks/year for executives

    // Stores the calculated vacation accrual rate per day
    private final double perDay;

    // Constructor to assign the per-day rate
    VacAccrual(double perDay){
        this.perDay = perDay;
    }

    // Getter method to retrieve the accrual rate per day
    public double perDay(){
        return perDay;
    }

    // Returns the vacation accrual rate per day based on the employee's role
    public static double byRole(Role r){
        double accrualRate = 0.0d;

        // Determine the appropriate rate using a switch-case
        switch(r){
            case EXECUTIVE: accrualRate = EXECUTIVE.perDay; break;
            case MANAGER: accrualRate = MANAGER.perDay; break;
            case STAFF: accrualRate = STAFF.perDay; break;
        }

        return accrualRate;
    }
}
