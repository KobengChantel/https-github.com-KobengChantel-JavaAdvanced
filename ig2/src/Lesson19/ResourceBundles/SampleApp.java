package Lesson19.ResourceBundles;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.ResourceBundle;

// This application demonstrates localization by allowing users to select a language locale,
// then displaying the current date and formatting a currency amount accordingly.

public class SampleApp {

    PrintWriter pw = new PrintWriter(System.out, true); // for console output
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // for user input

    Locale usLocale = Locale.US;
    Locale frLocale = Locale.FRANCE;
    Locale zhLocale = new Locale("zh", "CN");
    Locale ruLocale = new Locale("ru", "RU");
    Locale currentLocale = Locale.getDefault(); // default system locale

    ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", currentLocale); // localized messages
    NumberFormat currency;
    Double money = 1000000.00; // example amount to format
    LocalDateTime today = LocalDateTime.now(); // current date/time
    DateTimeFormatter df;

    public static void main(String[] args) {
        SampleApp ui = new SampleApp();
        ui.run(); // start the interactive loop
    }

    public void run() {
        String line = "";

        // Loop until user inputs 'q' to quit
        while (!line.equals("q")) {
            this.printMenu(); // show the menu
            try {
                line = this.br.readLine(); // read user input
            } catch (Exception e) {
                System.out.println("Error reading input: " + e.getLocalizedMessage());
            }

            // Handle user choices
            switch (line) {
                case "1": setEnglish(); break;
                case "2": setFrench(); break;
                case "3": setChinese(); break;
                case "4": setRussian(); break;
                case "5": showDate();  break;
                case "6": showMoney(); break;
            }
        }
    }

    // Print menu with localized options
    public void printMenu() {
        pw.println("=== Localization App ===");
        pw.println("1. " + messages.getString("menu1"));
        pw.println("2. " + messages.getString("menu2"));
        pw.println("3. " + messages.getString("menu3"));
        pw.println("4. " + messages.getString("menu4"));
        pw.println("5. " + messages.getString("menu5"));
        pw.println("6. " + messages.getString("menu6"));
        pw.println("q. " + messages.getString("menuq"));
        System.out.print(messages.getString("menucommand") + " ");
    }

    // Set locale to English and load corresponding resource bundle
    public void setEnglish() {
        currentLocale = usLocale;
        messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
    }

    // Set locale to French and load corresponding resource bundle
    public void setFrench() {
        currentLocale = frLocale;
        messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
    }

    // Set locale to Chinese and load corresponding resource bundle
    public void setChinese() {
        currentLocale = zhLocale;
        messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
    }

    // Set locale to Russian and load corresponding resource bundle
    public void setRussian() {
        currentLocale = ruLocale;
        messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
    }

    // Display current date formatted in the current locale
    public void showDate() {
        df = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(currentLocale);
        pw.println(today.format(df) + " " + currentLocale.toString());
    }

    // Display the example money amount formatted as currency in the current locale
    public void showMoney() {
        currency = NumberFormat.getCurrencyInstance(currentLocale);
        pw.println(currency.format(money) + " " + currentLocale.toString());
    }
}
