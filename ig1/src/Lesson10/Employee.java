package Lesson10;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Represents an Employee with personal and job-related details,
 * implemented using the Builder pattern for flexible object creation.
 */
public class Employee {

  // Employee attributes
  private String givenName;
  private String surName;
  private int age;
  private Gender gender;
  private Role role;
  private String dept;
  private LocalDate startDate;
  private double salary;
  private String eMail;
  private String phone;
  private String address;
  private String city;
  private String state;
  private String code;

  /**
   * Builder class to facilitate flexible and readable construction
   * of Employee instances.
   */
  public static class Builder {
    private String givenName = "";
    private String surName = "";
    private int age = 0;
    private Gender gender = Gender.FEMALE;
    private Role role = Role.STAFF;
    private String dept = "";
    private LocalDate startDate = LocalDate.of(1, 1, 1);
    private double salary = 0;
    private String eMail = "";
    private String phone = "";
    private String address = "";
    private String city = "";
    private String state = "";
    private String code = "";

    // Builder setters with fluent API style returning Builder itself
    public Builder givenName(String givenName){
      this.givenName = givenName;
      return this;
    }

    public Builder surName(String surName){
      this.surName = surName;
      return this;
    }

    public Builder age(int val){
      age = val;
      return this;
    }

    public Builder gender(Gender val){
      gender = val;
      return this;
    }

    public Builder role(Role val){
      role = val;
      return this;
    }

    public Builder dept(String val){
      dept = val;
      return this;
    }

    public Builder startDate(LocalDate val){
      startDate = val;
      return this;
    }

    public Builder salary(double val){
      salary = val;
      return this;
    }

    public Builder email(String val){
      eMail = val;
      return this;
    }

    public Builder phoneNumber(String val){
      phone = val;
      return this;
    }

    public Builder address(String val){
      address = val;
      return this;
    }

    public Builder city(String val){
      city = val;
      return this;
    }

    public Builder state(String val){
      state = val;
      return this;
    }

    public Builder code(String val){
      code = val;
      return this;
    }

    // Builds and returns an Employee instance with the current builder state
    public Employee build(){
      return new Employee(this);
    }
  }

  // Private default constructor
  private Employee(){
    super();
  }

  // Private constructor to create Employee from Builder
  private Employee(Builder builder){
    givenName = builder.givenName;
    surName = builder.surName;
    age = builder.age;
    gender = builder.gender;
    role = builder.role;
    dept = builder.dept;
    startDate = builder.startDate;
    salary = builder.salary;
    eMail = builder.eMail;
    phone = builder.phone;
    address = builder.address;
    city = builder.city;
    state = builder.state;
    code = builder.code;
  }

  /**
   * Compares two employees by salary for sorting purposes.
   * @param a first employee
   * @param b second employee
   * @return negative if a < b, 0 if equal, positive if a > b
   */
  public static int sortBySalary(Employee a, Employee b){
    Double s1 = Double.valueOf(a.getSalary());
    Double s2 = Double.valueOf(b.getSalary());
    return s1.compareTo(s2);
  }

  // Getters and setters
  public String getGivenName(){
    return givenName;
  }

  public String getSurName(){
    return surName;
  }

  public void setSurName(String name){
    this.surName = name;
  }

  public int getAge(){
    return age;
  }

  public Gender getGender(){
    return gender;
  }

  public Role getRole(){
    return role;
  }

  public String getDept(){
    return dept;
  }

  public LocalDate getStartDate(){
    return startDate;
  }

  public double getSalary(){
    return salary;
  }

  public String getEmail(){
    return eMail;
  }

  public String getPhone(){
    return phone;
  }

  public String getAddress(){
    return address;
  }

  public String getCity(){
    return city;
  }

  public String getState(){
    return state;
  }

  public String getCode(){
    return code;
  }

  /**
   * Returns a brief summary string of this employee.
   * @return summary string
   */
  public String getSummary(){
    return "Name: " + givenName + " " + surName +
            " Role: " + role +
            " Dept: " + dept +
            " St: " + state +
            " Salary: " + salary;
  }

  /**
   * Prints detailed employee information to the console.
   */
  public void print(){
    System.out.println(
            "\nName: " + givenName + " " + surName + "\n" +
                    "Age: " + age + "\n" +
                    "Gender: " + gender + "\n" +
                    "Role: " + role + "\n" +
                    "Dept: " + dept + "\n" +
                    "Start date: " + startDate + "\n" +
                    "Salary: " + salary + "\n" +
                    "eMail: " + eMail + "\n" +
                    "Phone: " + phone + "\n" +
                    "Address: " + address + "\n" +
                    "City: " + city + "\n" +
                    "State: " + state + "\n" +
                    "Code: " + code + "\n"
    );
  }

  /**
   * Prints a summary line of employee information formatted with salary.
   */
  public void printSummary(){
    System.out.printf(
            "Name: " + givenName + " " + surName +
                    " Role: " + role +
                    " Dept: " + dept +
                    " St: " + state +
                    " Salary: $%,9.2f %n", salary
    );
  }

  /**
   * Accepts a Consumer functional interface to perform custom actions on this employee.
   * @param cons Consumer action to perform
   */
  public void printLambda(Consumer<Employee> cons){
    cons.accept(this);
  }

  /**
   * Returns a string representation of the employee with all details.
   */
  @Override
  public String toString(){
    return "Name: " + givenName + " " + surName +
            " Age: " + age +
            " Gender: " + gender +
            " Role: " + role +
            " Dept: " + dept +
            " Start date: " + startDate +
            " Salary: " + salary +
            " eMail: " + eMail +
            " Phone: " + phone +
            " Address: " + address +
            " City: " + city +
            " State: " + state +
            " Code: " + code + "\n";
  }

  /**
   * Creates a short list of sample Employee instances.
   * @return list of Employee objects
   */
  public static List<Employee> createShortList(){
    List<Employee> people = new ArrayList<>();

    people.add(
            new Builder()
                    .givenName("Bob")
                    .surName("Baker")
                    .age(23)
                    .gender(Gender.MALE)
                    .role(Role.STAFF)
                    .dept("Eng")
                    .startDate(LocalDate.of(2013, 1, 10))
                    .salary(40000)
                    .email("bob.baker@example.com")
                    .phoneNumber("201-121-4678")
                    .address("44 4th St")
                    .city("Smallville")
                    .state("KS")
                    .code("12333")
                    .build()
    );

    people.add(
            new Builder()
                    .givenName("Jane")
                    .surName("Doe")
                    .age(25)
                    .gender(Gender.FEMALE)
                    .role(Role.STAFF)
                    .dept("Sales")
                    .startDate(LocalDate.of(2011, 7, 14))
                    .salary(45000)
                    .email("jane.doe@example.com")
                    .phoneNumber("202-123-4678")
                    .address("33 3rd St")
                    .city("Smallville")
                    .state("KS")
                    .code("12333")
                    .build()
    );

    people.add(
            new Builder()
                    .givenName("John")
                    .surName("Doe")
                    .age(28)
                    .gender(Gender.MALE)
                    .role(Role.MANAGER)
                    .dept("Eng")
                    .startDate(LocalDate.of(2007, 3, 1))
                    .salary(65000)
                    .email("john.doe@example.com")
                    .phoneNumber("202-123-4678")
                    .address("33 3rd St")
                    .city("Smallville")
                    .state("KS")
                    .code("12333")
                    .build()
    );

    people.add(
            new Builder()
                    .givenName("James")
                    .surName("Johnson")
                    .age(45)
                    .gender(Gender.MALE)
                    .role(Role.MANAGER)
                    .dept("Eng")
                    .startDate(LocalDate.of(1999, 5, 1))
                    .salary(85000)
                    .email("james.johnson@example.com")
                    .phoneNumber("333-456-1233")
                    .address("201 2nd St")
                    .city("BrainTree")
                    .state("MA")
                    .code("11111")
                    .build()
    );

    people.add(
            new Builder()
                    .givenName("John")
                    .surName("Adams")
                    .age(52)
                    .gender(Gender.MALE)
                    .role(Role.MANAGER)
                    .dept("Sales")
                    .startDate(LocalDate.of(1994, 2, 1))
                    .salary(90000)
                    .email("john.adams@example.com")
                    .phoneNumber("112-111-1111")
                    .address("111 1st St")
                    .city("Braintree")
                    .state("MA")
                    .code("11111")
                    .build()
    );

    people.add(
            new Builder()
                    .givenName("Joe")
                    .surName("Bailey")
                    .age(62)
                    .gender(Gender.MALE)
                    .role(Role.EXECUTIVE)
                    .dept("Eng")
                    .startDate(LocalDate.of(1992, 1, 5))
                    .salary(120000)
                    .email("joebob.bailey@example.com")
                    .phoneNumber("112-111-1111")
                    .address("111 1st St")
                    .city("Town")
                    .state("CO")
                    .code("11111")
                    .build()
    );

    people.add(
            new Builder()
                    .givenName("Phil")
                    .surName("Smith")
                    .age(55)
                    .gender(Gender.MALE)
                    .role(Role.EXECUTIVE)
                    .dept("HR")
                    .startDate(LocalDate.of(2000, 10, 10))
                    .salary(110000)
                    .email("phil.smith@examp;e.com")
                    .phoneNumber("222-33-1234")
                    .address("22 2nd St")
                    .city("New Park")
                    .state("CO")
                    .code("222333")
                    .build()
    );

    people.add(
            new Builder()
                    .givenName("Betty")
                    .surName("Jones")
                    .age(65)
                    .gender(Gender.FEMALE)
                    .role(Role.EXECUTIVE)
                    .dept("Sales")
                    .startDate(LocalDate.of(1984, 7, 10))
                    .salary(140000)
                    .email("betty.jones@example.com")
                    .phoneNumber("211-33-1234")
                    .address("22 4th St")
                    .city("New Park")
                    .state("CO")
                    .code("222333")
                    .build()
    );

    return people;
  }
}
