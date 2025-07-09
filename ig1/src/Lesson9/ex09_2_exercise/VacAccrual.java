package Lesson9.ex09_2_exercise;

// This enum defines daily vacation accrual rates for different roles and provides a method to retrieve the rate based on a role.

public enum VacAccrual {

    // Enum constants with daily vacation accrual values (calculated as weeks * days / 365)
    STAFF((2 * 7) / 365d),
    MANAGER((2.5 * 7) / 365d),
    EXECUTIVE((3 * 7) / 365d);

    // Field to store accrual rate per day
    private final double perDay;

    // Constructor to initialize accrual rate
    VacAccrual(double perDay){
        this.perDay = perDay;
    }

    // Getter method to return accrual rate per day
    public double perDay(){
        return perDay;
    }

    // Static method that returns the accrual rate based on role
    public static double byRole(Role r){
        double accrualRate = 0.0d;

        // Use switch to determine which rate to return
        switch(r){
            case EXECUTIVE: accrualRate = EXECUTIVE.perDay; break;
            case MANAGER: accrualRate = MANAGER.perDay; break;
            case STAFF: accrualRate = STAFF.perDay; break;
        }

        return accrualRate;
    }
}
