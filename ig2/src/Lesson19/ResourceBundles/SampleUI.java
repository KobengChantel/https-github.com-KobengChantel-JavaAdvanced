package Lesson19.ResourceBundles;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

// This class provides a simple command-line interface for a localization app,
// allowing the user to select languages and display localized date and money information.
public class SampleUI {
    // PrintWriter for outputting text to the console, auto-flushing after each println
    PrintWriter pw = new PrintWriter(System.out, true);
    // BufferedReader to read input from the console
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args){
        // Create an instance of SampleUI and start the application
        SampleUI ui = new SampleUI();
        ui.run();
    }

    // Main loop of the application, keeps running until user enters "q"
    public void run(){
        String line = "";

        // Loop until user inputs 'q' to quit
        while (!(line.equals("q"))){
            this.printMenu();  // Display the menu options
            try {
                line = this.br.readLine();  // Read user input from console
            }
            catch (Exception e){
                e.printStackTrace();  // Print error if input reading fails
            }

            // Respond to user commands based on input
            switch (line){
                case "1": setEnglish(); break;  // Set language to English
                case "2": setFrench(); break;   // Set language to French
                case "3": setChinese(); break;  // Set language to Chinese
                case "4": setRussian(); break;  // Set language to Russian
                case "5": showDate(); break;    // Show localized date
                case "6": showMoney(); break;   // Show localized money format
            }
        }
    }

    // Prints the menu of available commands to the user
    public void printMenu(){
        pw.println("=== Localization App ===");
        pw.println("1. Set to English");
        pw.println("2. Set to French");
        pw.println("3. Set to Chinese");
        pw.println("4. Set to Russian");
        pw.println("5. Show me the date");
        pw.println("6. Show me the money!");
        pw.println("q. Enter q to quit");
        System.out.print("Enter a command: ");
    }

    // Placeholder method to switch localization to English
    public void setEnglish(){

    }

    // Placeholder method to switch localization to French
    public void setFrench(){

    }

    // Placeholder method to switch localization to Chinese
    public void setChinese(){

    }

    // Placeholder method to switch localization to Russian
    public void setRussian(){

    }

    // Placeholder method to display the current date in the selected locale format
    public void showDate(){

    }

    // Placeholder method to display monetary values formatted according to the selected locale
    public void showMoney(){

    }
}
