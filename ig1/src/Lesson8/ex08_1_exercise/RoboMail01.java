package Lesson8.ex08_1_exercise;

// This class provides basic functionality to send email and text notifications to an Employee by printing their contact details.

public class RoboMail01 {

  // Sends a simulated email to the employee by printing their name, age, and email address
  public void roboMail(Employee p){
    System.out.println("Emailing: " + p.getGivenName()
            + " " + p.getSurName() + " age " + p.getAge()
            + " at " + p.getEmail());
  }

  // Sends a simulated text message to the employee by printing their name, age, and phone number
  public void roboText(Employee p) {
    System.out.println("Texting: " + p.getGivenName()
            + " " + p.getSurName() + " age " + p.getAge()
            + " at " + p.getPhone());
  }
}
