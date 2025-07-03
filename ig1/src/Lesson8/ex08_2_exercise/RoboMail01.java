package Lesson8.ex08_2_exercise;

// This class simulates sending email and text notifications to employees by printing their contact details.

public class RoboMail01 {

  // Simulates emailing an employee by printing their name, age, and email address
  public void roboMail(Employee p){
    System.out.println("Emailing: " + p.getGivenName()
            + " " + p.getSurName() + " age " + p.getAge()
            + " at " + p.getEmail());
  }

  // Simulates texting an employee by printing their name, age, and phone number
  public void roboText(Employee p) {
    System.out.println("Texting: " + p.getGivenName()
            + " " + p.getSurName() + " age " + p.getAge()
            + " at " + p.getPhone());
  }
}
