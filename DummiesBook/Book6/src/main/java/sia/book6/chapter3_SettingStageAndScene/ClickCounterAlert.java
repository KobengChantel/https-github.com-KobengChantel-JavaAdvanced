package sia.book6.chapter3_SettingStageAndScene;

// The ClickCounterAlert Program

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ClickCounterAlert extends Application {

    // Main method to launch the JavaFX application
    public static void main(String[] args) {
        launch(args); // Launch the application
    }

    // GUI components
    Button btn; // Button to be clicked
    Label lbl; // Label to display click counts (currently unused)
    int iClickCount = 0; // Counter for button clicks

    @Override
    public void start(Stage primaryStage) {
        // Create the button
        btn = new Button();
        btn.setText("Click me please!"); // Set the button text

        // Define action for the button when clicked
        btn.setOnAction(e -> buttonClick());

        // Create a layout pane and add the button to it
        BorderPane pane = new BorderPane();
        pane.setCenter(btn); // Center the button in the layout pane

        // Create a scene with the layout pane
        Scene scene = new Scene(pane, 250, 150);

        // Set the scene on the primary stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Click Counter"); // Set the window title
        primaryStage.show(); // Display the primary stage
    }

    // Method to handle button clicks
    public void buttonClick() {
        iClickCount++; // Increment the click count

        // Create an alert dialog to inform the user of the click count
        Alert a;
        if (iClickCount == 1) {
            // If it's the first click, display a specific message
            a = new Alert(Alert.AlertType.INFORMATION, "You have clicked once.");
        } else {
            // For subsequent clicks, display the count
            a = new Alert(Alert.AlertType.INFORMATION, "You have clicked " + iClickCount + " times.");
        }

        // Show the alert dialog and wait for the user to respond
        a.showAndWait();
    }
}
