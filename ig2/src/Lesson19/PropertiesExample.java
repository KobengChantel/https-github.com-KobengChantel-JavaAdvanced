package Lesson19;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

// This class demonstrates loading key-value pairs from a properties file and printing them.
public class PropertiesExample {
    public static void main(String[] args) {

        // Create a Properties object to hold configuration key-value pairs
        Properties myProps = new Properties();

        try {
            // Open the properties file as an input stream
            FileInputStream fis = new FileInputStream("C:\\Bootcamp\\JAVA\\Java_Advanced\\java_work\\ig2\\src\\Lesson19\\ServerInfo.properties");

            // Load properties from the input stream into the Properties object
            myProps.load(fis);
        } catch (IOException e) {
            // Print error message if file reading or loading fails
            System.out.println("Error: " + e.getMessage());
        }

        // Print the loaded property values by their keys
        System.out.println("Server: " + myProps.getProperty("hostName"));
        System.out.println("User: " + myProps.getProperty("userName"));
        System.out.println("Password: " + myProps.getProperty("password"));
    }
}
