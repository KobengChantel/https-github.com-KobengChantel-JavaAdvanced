package sia.book6.chapter5_GettingInputFromUser;

import javafx.application.Application; // Import the Application class for JavaFX
import javafx.scene.Scene; // Import Scene class for setting up the GUI
import javafx.scene.control.Alert; // Import Alert class for displaying messages
import javafx.scene.control.Button; // Import Button class for creating buttons
import javafx.scene.control.TextField; // Import TextField class for user input
import javafx.scene.layout.VBox; // Import VBox for layout management
import javafx.stage.Stage; // Import Stage class for window management

public class IntegerInputApp extends Application {

    private TextField textCount; // Declare a TextField for integer input

    public static void main(String[] args) {
        launch(args); // Launch the JavaFX application
    }

    @Override
    public void start(Stage primaryStage) {
        // Initialize the TextField with a prompt message
        textCount = new TextField();
        textCount.setPromptText("Enter an integer");

        // Create an OK button and set its action
        Button buttonOK = new Button("OK");
        buttonOK.setOnAction(e -> buttonOKClick()); // Call buttonOKClick() when clicked

        // Create a VBox layout to arrange the TextField and button vertically
        VBox layout = new VBox(10, textCount, buttonOK);
        Scene scene = new Scene(layout, 300, 150); // Create a scene with the layout

        primaryStage.setTitle("Integer Input Checker"); // Set the window title
        primaryStage.setScene(scene); // Set the scene to the primary stage
        primaryStage.show(); // Display the stage
    }

    /**
     * Method to check if the input in the TextField is an integer.
     *
     * @param f   The TextField to check.
     * @param msg The message to display in case of invalid input.
     * @return true if the input is a valid integer, false otherwise.
     */
    private boolean isInt(TextField f, String msg) {
        try {
            // Try to parse the input as an integer
            Integer.parseInt(f.getText());
            return true; // Return true if parsing is successful
        } catch (NumberFormatException e) {
            // Display an alert if parsing fails
            Alert a = new Alert(Alert.AlertType.WARNING, msg);
            a.setTitle("Invalid Data"); // Set the title for the alert
            a.showAndWait(); // Show the alert and wait for user response
            return false; // Return false for invalid input
        }
    }

    /**
     * Method called when the OK button is clicked.
     */
    public void buttonOKClick() {
        // Validate the input; if valid, show the entered number
        if (isInt(textCount, "You must enter an integer.")) {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Your Number"); // Set the title for the alert
            a.setHeaderText(null); // Optional: No header for the alert
            a.setContentText("You entered " + Integer.parseInt(textCount.getText())); // Show the entered integer
            a.showAndWait(); // Show the alert and wait for user response
        }
        textCount.requestFocus(); // Focus back on the TextField for user input
    }
}
