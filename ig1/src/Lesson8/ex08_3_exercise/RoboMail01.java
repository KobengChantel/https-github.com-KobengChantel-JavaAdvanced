package Lesson8.ex08_3_exercise;

// This class provides methods to simulate sending emails and text messages to employees by printing their contact details.

public class RoboMail01 {

  // Simulates sending an email by printing the employee's name, age, and email address
  public void roboMail(Employee p){
    System.out.println("Emailing: " + p.getGivenName()
            + " " + p.getSurName() + " age " + p.getAge()
            + " at " + p.getEmail());
  }

  // Simulates sending a text message by printing the employee's name, age, and phone number
  public void roboText(Employee p) {
    System.out.println("Texting: " + p.getGivenName()
            + " " + p.getSurName() + " age " + p.getAge()
            + " at " + p.getPhone());
  }
}
