package Lesson8.ex08_1_exercise;

import java.util.ArrayList;
import java.util.List;

// This class defines an Employee using the Builder pattern and provides a sample list of Employee objects.

// Enum placeholders (assumed to exist)
// enum Gender { MALE, FEMALE }
// enum Role { STAFF, MANAGER, EXECUTIVE }

public class Employee {
  // Employee attributes
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

  // Builder pattern for creating Employee objects
  public static class Builder {
    private String givenName = "";
    private String surName = "";
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

    // Setter methods for each field returning the builder instance
    public Builder givenName(String givenName) {
      this.givenName = givenName;
      return this;
    }

    public Builder surName(String surName) {
      this.surName = surName;
      return this;
    }

    public Builder age(int val) {
      age = val;
      return this;
    }

    public Builder gender(Gender val) {
      gender = val;
      return this;
    }

    public Builder role(Role val) {
      role = val;
      return this;
    }

    public Builder dept(String val) {
      dept = val;
      return this;
    }

    public Builder email(String val) {
      eMail = val;
      return this;
    }

    public Builder phoneNumber(String val) {
      phone = val;
      return this;
    }

    public Builder address(String val) {
      address = val;
      return this;
    }

    public Builder city(String val) {
      city = val;
      return this;
    }

    public Builder state(String val) {
      state = val;
      return this;
    }

    public Builder code(String val) {
      code = val;
      return this;
    }

    // Builds and returns the Employee object
    public Employee build() {
      return new Employee(this);
    }
  }

  // Private constructor for builder
  private Employee() {
    super();
  }

  // Private constructor that copies values from the Builder
  private Employee(Builder builder) {
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
  public String getGivenName() {
    return givenName;
  }

  public String getSurName() {
    return surName;
  }

  public int getAge() {
    return age;
  }

  public Gender getGender() {
    return gender;
  }

  public Role getRole() {
    return role;
  }

  public String getDept() {
    return dept;
  }

  public String getEmail() {
    return eMail;
  }

  public String getPhone() {
    return phone;
  }

  public String getAddress() {
    return address;
  }

  public String getCity() {
    return city;
  }

  public String getState() {
    return state;
  }

  public String getCode() {
    return code;
  }

  // Prints all employee details in a formatted manner
  public void print() {
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

  // Returns a short string summary of the employee
  @Override
  public String toString() {
    return "Name: " + givenName + " " + surName + "\n" +
            "Age: " + age + "  Gender: " + gender + "\n" +
            "eMail: " + eMail + "\n" +
            " Role: " + role + " Dept: " + dept;
  }

  // Creates a list of sample Employee objects using the builder
  public static List<Employee> createShortList() {
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
