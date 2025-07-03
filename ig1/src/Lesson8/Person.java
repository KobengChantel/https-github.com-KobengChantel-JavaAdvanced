package Lesson8;

import java.util.ArrayList;
import java.util.List;

/**
 * This class models a Person with personal details, supporting flexible object creation via the Builder pattern.
 */
public class Person {
  private String givenName;
  private String surName;
  private int age;
  private Gender gender;
  private String eMail;
  private String phone;
  private String address;
  private String city;
  private String state;
  private String code;

  // Builder class for step-by-step Person construction
  public static class Builder{

    private String givenName = "";
    private String surName = "";
    private int age = 0;
    private Gender gender = Gender.FEMALE;
    private String eMail = "";
    private String phone = "";
    private String address = "";
    private String city = "";
    private String state = "";
    private String code = "";

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

    // Builds and returns the Person object with the set properties
    public Person build(){
      return new Person(this);
    }
  }

  // Private no-arg constructor to prevent direct instantiation
  private Person(){
    super();
  }

  // Private constructor used by Builder to set fields
  private Person(Builder builder){
    givenName = builder.givenName;
    surName = builder.surName;
    age = builder.age;
    gender = builder.gender;
    eMail = builder.eMail;
    phone = builder.phone;
    address = builder.address;
    city = builder.city;
    state = builder.state;
    code = builder.code;
  }

  // Getter methods for all fields
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

  // Prints all person details in a formatted manner
  public void print(){
    System.out.println(
            "\nName: " + givenName + " " + surName + "\n" +
                    "Age: " + age + "\n" +
                    "Gender: " + gender + "\n" +
                    "eMail: " + eMail + "\n" +
                    "Phone: " + phone + "\n" +
                    "Address: " + address + "\n" +
                    "City: " + city + "\n" +
                    "State: " + state + "\n" +
                    "Code: " + code + "\n"
    );
  }

  // Provides a brief string representation of the Person
  @Override
  public String toString(){
    return "Name: " + givenName + " " + surName + "\n" +
            "Age: " + age + "  Gender: " + gender + "\n" +
            "eMail: " + eMail + "\n";
  }

  // Creates and returns a sample list of Person objects
  public static List<Person> createShortList(){
    List<Person> people = new ArrayList<>();

    people.add(
            new Builder()
                    .givenName("Bob")
                    .surName("Baker")
                    .age(21)
                    .gender(Gender.MALE)
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
                    .age(25)
                    .gender(Gender.MALE)
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
                    .givenName("Joe")
                    .surName("Bailey")
                    .age(67)
                    .gender(Gender.MALE)
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
                    .age(85)
                    .gender(Gender.FEMALE)
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
