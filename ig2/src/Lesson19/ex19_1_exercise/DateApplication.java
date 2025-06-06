package Lesson19.ex19_1_exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.ResourceBundle;

// This application displays the current date and time in multiple localized formats and allows the user to switch between languages interactively.

public class DateApplication {
    PrintWriter pw = new PrintWriter(System.out, true); // for output to console
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // for input from user

    Locale ruLocale = new Locale("ru", "RU"); // Russian locale
    Locale currentLocale = Locale.US; // default locale (English - US)
    ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", Locale.US); // message bundle for localization

    LocalDateTime today = LocalDateTime.now(); // current date and time
    DateTimeFormatter df; // formatter for date/time display

    public static void main(String[] args) {
        DateApplication dateApp = new DateApplication();
        dateApp.run(); // start the application loop
    }

    public void run() {
        String line = "";

        // Loop until user enters 'q' to quit
        while (!line.equals("q")) {
            this.printMenu(); // display date/time and language menu
            try {
                line = this.br.readLine(); // read user input
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }

            // Change locale based on user input
            switch (line) {
                case "1":
                    this.setEnglish();
                    break;
                case "2":
                    this.setFrench();
                    break;
                case "3":
                    this.setChinese();
                    break;
                case "4":
                    this.setRussian();
                    break;
            }
        }
    }

    public void printMenu() {
        pw.println("=== Date App ===");

        // Display current date/time in various localized formats

        // Full Date
        df = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(currentLocale);
        pw.println(messages.getString("date1") + " " + today.format(df));

        // Long Date
        df = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).withLocale(currentLocale);
        pw.println(messages.getString("date2") + " " + today.format(df));

        // Short Date
        df = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).withLocale(currentLocale);
        pw.println(messages.getString("date3") + " " + today.format(df));

        // Medium Date/Time
        df = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(currentLocale);
        pw.println(messages.getString("date4") + " " + today.format(df));

        // Medium Time
        df = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM).withLocale(currentLocale);
        pw.println(messages.getString("date5") + " " + today.format(df));

        // Display language selection menu
        pw.println("\n--- Choose Language Option ---");
        pw.println("1. " + messages.getString("menu1"));
        pw.println("2. " + messages.getString("menu2"));
        pw.println("3. " + messages.getString("menu3"));
        pw.println("4. " + messages.getString("menu4"));
        pw.println("q. " + messages.getString("menuq"));
        System.out.print(messages.getString("menucommand") + " ");
    }

    // Methods to set the current locale and update the resource bundle accordingly

    public void setEnglish() {
        currentLocale = Locale.US;
        messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
    }

    public void setFrench() {
        currentLocale = Locale.FRANCE;
        messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
    }

    public void setChinese() {
        currentLocale = Locale.SIMPLIFIED_CHINESE;
        messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
    }

    public void setRussian() {
        currentLocale = ruLocale;
        this.messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
    }
}
