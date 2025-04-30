//class declaration
public class Employee {
    //fields
public int empId;
public String name;
public String ssn;
public double salary;
    //a constructor
    //is used to create the instance of a class
    //are declared with the same name as their class
    //they can take argumenats
    //and can take more than one contructor
public Employee(){

}

    public void setEmpId(int empId) {
    //this keyword //is used by set method
        //it allows the compiler to distinguash between the field name of the class(this) and the parameter being passed in an argument
        //without this keyword u will be assigning a value to itself
        this.empId = empId;
    }

    //a method
    public int getEmpId(){
    return empId;
    }
    // getters(accessor)
    //setters(mutators)

    //creating an instance of a class(object) of class we use the New keyword
    //new operator used and to initialize all the instance variable of a class, the contsructor is invoked
    //instance object is created when u use the new operator with a contsructor


//    Employee emp = new Employee();
//emp.empId = (101);
//emp.setEmpId(101);
//emp.setName("Nanu Slash");
//emp.setSsn("011-22-3467");
//emp.setSalary(120345.27);

}
