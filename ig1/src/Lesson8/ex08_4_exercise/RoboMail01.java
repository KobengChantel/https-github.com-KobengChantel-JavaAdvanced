package Lesson8.ex08_4_exercise;

/**
 * RoboMail01 provides simple methods to simulate sending an email or text message
 * to an Employee by printing their contact details.
 */
public class RoboMail01 {

  // Prints a message simulating sending an email to the employee
  public void roboMail(Employee p){
    System.out.println("Emailing: " + p.getGivenName()
            + " " + p.getSurName() + " age " + p.getAge()
            + " at " + p.getEmail());
  }

  // Prints a message simulating sending a text message to the employee
  public void roboText(Employee p) {
    System.out.println("Texting: " + p.getGivenName()
            + " " + p.getSurName() + " age " + p.getAge()
            + " at " + p.getPhone());
  }
}
