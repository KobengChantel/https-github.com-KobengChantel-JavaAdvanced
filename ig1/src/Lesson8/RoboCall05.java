package Lesson8;

import java.util.List;
import java.util.function.Predicate;

/**
 * RoboCall05 handles contacting a list of Person objects via phone, email, or mail,
 * filtering the list by a provided Predicate<Person>.
 */
public class RoboCall05 {

  // Calls each person in the list that matches the predicate
  public void phoneContacts(List<Person> pl, Predicate<Person> pred){
    for(Person p : pl){
      if (pred.test(p)){
        roboCall(p);
      }
    }
  }

  // Emails each person in the list that matches the predicate
  public void emailContacts(List<Person> pl, Predicate<Person> pred){
    for(Person p : pl){
      if (pred.test(p)){
        roboEmail(p);
      }
    }
  }

  // Sends postal mail to each person in the list that matches the predicate
  public void mailContacts(List<Person> pl, Predicate<Person> pred){
    for(Person p : pl){
      if (pred.test(p)){
        roboMail(p);
      }
    }
  }

  // Prints a simulated phone call message
  public void roboCall(Person p){
    System.out.println("Calling " + p.getGivenName() + " " + p.getSurName() +
            " age " + p.getAge() + " at " + p.getPhone());
  }

  // Prints a simulated email message
  public void roboEmail(Person p){
    System.out.println("EMailing " + p.getGivenName() + " " + p.getSurName() +
            " age " + p.getAge() + " at " + p.getEmail());
  }

  // Prints a simulated postal mail message
  public void roboMail(Person p){
    System.out.println("Mailing " + p.getGivenName() + " " + p.getSurName() +
            " age " + p.getAge() + " at " + p.getAddress() + ", " +
            p.getCity() + ", " + p.getState() + " " + p.getCode());
  }
}
