package Lesson8.ex08_4_exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * This class models an Employee with multiple personal and job-related attributes,
 * supporting construction via the Builder pattern for flexible and readable object creation.
 *
 * @author MikeW
 */
public class Employee {
  private String givenName;
  private String surName;
  private int age;
  private Gender gender;
  private Role role;
  private String dept;
  private String eMail;
  private String phone;
  private String address;
  private String city;
  private String state;
  private String code;

  // Builder class to help build Employee objects step-by-step
  public static class Builder{

    private String givenName="";
    private String surName="";
    private int age = 0;
    private Gender gender = Gender.FEMALE;
    private Role role = Role.STAFF;
    private String dept = "";
    private String eMail = "";
    private String phone = "";
    private String address = "";
    private String city = "";
    private String state = "";
    private String code = "";

    // Sets givenName and returns Builder for chaining
    public Builder givenName(String givenName){
      this.givenName = givenName;
      return this;
    }

    // Sets surName and returns Builder for chaining
    public Builder surName(String surName){
      this.surName = surName;
      return this;
    }

    // Sets age and returns Builder for chaining
    public Builder age (int val){
      age = val;
      return this;
    }

    // Sets gender and returns Builder for chaining
    public Builder gender(Gender val){
      gender = val;
      return this;
    }

    // Sets role and returns Builder for chaining
    public Builder role(Role val){
      role = val;
      return this;
    }

    // Sets department and returns Builder for chaining
    public Builder dept(String val){
      dept = val;
      return this;
    }

    // Sets email and returns Builder for chaining
    public Builder email(String val){
      eMail = val;
      return this;
    }

    // Sets phone number and returns Builder for chaining
    public Builder phoneNumber(String val){
      phone = val;
      return this;
    }

    // Sets address and returns Builder for chaining
    public Builder address(String val){
      address = val;
      return this;
    }

    // Sets city and returns Builder for chaining
    public Builder city(String val){
      city = val;
      return this;
    }

    // Sets state and returns Builder for chaining
    public Builder state(String val){
      state = val;
      return this;
    }

    // Sets code (postal or other) and returns Builder for chaining
    public Builder code(String val){
      code = val;
      return this;
    }

    // Builds and returns the Employee object using the current Builder state
    public Employee build(){
      return new Employee(this);
    }
  }

  // Private default constructor to prevent direct instantiation
  private Employee(){
    super();
  }

  // Private constructor that initializes fields from the Builder
  private Employee(Builder builder){
    givenName = builder.givenName;
    surName = builder.surName;
    age = builder.age;
    gender = builder.gender;
    role = builder.role;
    dept = builder.dept;
    eMail = builder.eMail;
    phone = builder.phone;
    address = builder.address;
    city = builder.city;
    state = builder.state;
    code = builder.code;
  }

  // Getters for all fields
  public String getGivenName(){
    return givenName;
  }

  public String getSurName(){
    return surName;
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

  // Prints all employee information in a formatted way
  public void print(){
    System.out.println(
            "\nName: " + givenName + " " + surName + "\n" +
                    "Age: " + age + "\n" +
                    "Gender: " + gender + "\n" +
                    "Role: " + role + "\n" +
                    "Dept: " + dept + "\n" +
                    "eMail: " + eMail + "\n" +
                    "Phone: " + phone + "\n" +
                    "Address: " + address + "\n" +
                    "City: " + city + "\n" +
                    "State: " + state + "\n" +
                    "Code: " + code + "\n"
    );
  }

  // Returns a brief string representation of employee details
  @Override
  public String toString(){
    return "Name: " + givenName + " " + surName + "\n" + "Age: " + age + "  Gender: " + gender + "\n" + "eMail: " + eMail + "\n" + " Role: " + role + " Dept: " + dept;
  }

  // Creates and returns a sample list of Employees using the Builder pattern
  public static List<Employee> createShortList(){
    List<Employee> people = new ArrayList<>();

    people.add(
            new Builder()
                    .givenName("Bob")
                    .surName("Baker")
                    .age(23)
                    .gender(Gender.MALE)
                    .role(Role.STAFF)
                    .dept("ENG")
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
                    .dept("HR")
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
                    .email("james.johnson@example.com")
                    .phoneNumber("333-456-1233")
                    .address("201 2nd St")
                    .city("New York")
                    .state("NY")
                    .code("12111")
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
                    .email("joebob.bailey@example.com")
                    .phoneNumber("112-111-1111")
                    .address("111 1st St")
                    .city("Town")
                    .state("CA")
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
