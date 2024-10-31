package sia.book6.chapter5_GettingInputFromUser;

import javafx.application.Application; // Import Application class for JavaFX
import javafx.scene.Scene; // Import Scene class for GUI setup
import javafx.scene.control.Alert; // Import Alert class for displaying messages
import javafx.scene.control.CheckBox; // Import CheckBox class for user selections
import javafx.scene.control.Button; // Import Button class for actions
import javafx.scene.layout.VBox; // Import VBox for layout management
import javafx.stage.Stage; // Import Stage class for window management

public class PizzaOrderApp extends Application {

    private CheckBox chkPepperoni; // Checkbox for Pepperoni
    private CheckBox chkMushrooms; // Checkbox for Mushrooms
    private CheckBox chkAnchovies; // Checkbox for Anchovies

    public static void main(String[] args) {
        launch(args); // Launch the JavaFX application
    }

    @Override
    public void start(Stage primaryStage) {
        // Initialize checkboxes for toppings
        chkPepperoni = new CheckBox("Pepperoni");
        chkPepperoni.setSelected(true); // Set Pepperoni checkbox to selected by default

        chkMushrooms = new CheckBox("Mushrooms");
        chkAnchovies = new CheckBox("Anchovies");

        // Create an OK button to confirm the order
        Button btnOK = new Button("OK");
        btnOK.setOnAction(e -> btnOK_Click()); // Set action for button click

        // Create a VBox layout to arrange checkboxes and button vertically
        VBox pane1 = new VBox(10, chkPepperoni, chkMushrooms, chkAnchovies, btnOK);
        Scene scene = new Scene(pane1, 300, 200); // Create a scene with the layout

        primaryStage.setTitle("Pizza Toppings Order"); // Set the window title
        primaryStage.setScene(scene); // Set the scene to the primary stage
        primaryStage.show(); // Display the stage
    }

    /**
     * Method called when the OK button is clicked.
     * It checks which toppings were selected and displays an alert.
     */
    public void btnOK_Click() {
        String msg = ""; // Initialize message string

        // Check which toppings are selected and build the message
        if (chkPepperoni.isSelected()) {
            msg += "Pepperoni\n"; // Add Pepperoni to the message
        }
        if (chkMushrooms.isSelected()) {
            msg += "Mushrooms\n"; // Add Mushrooms to the message
        }
        if (chkAnchovies.isSelected()) {
            msg += "Anchovies\n"; // Add Anchovies to the message
        }

        // If no toppings are selected, set the message accordingly
        if (msg.equals("")) {
            msg = "You didn't order any toppings.";
        } else {
            msg = "You ordered these toppings:\n" + msg; // Set the message with the selected toppings
        }

        // Create an alert to display the order summary
        Alert a = new Alert(Alert.AlertType.INFORMATION, msg);
        a.setTitle("Your Order"); // Set the title for the alert
        a.showAndWait(); // Show the alert and wait for user response

        // Reset the checkboxes after showing the alert
        chkPepperoni.setSelected(false);
        chkMushrooms.setSelected(false);
        chkAnchovies.setSelected(false);
    }
}

