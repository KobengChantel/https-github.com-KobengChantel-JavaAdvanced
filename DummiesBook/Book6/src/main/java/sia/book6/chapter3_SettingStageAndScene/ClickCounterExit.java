package sia.book6.chapter3_SettingStageAndScene;
//listing 3.3
// The ClickCounterExit program

// The ClickCounterExit program

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class ClickCounterExit extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    Stage stage; // Stage to control the application window
    int iClickCount = 0; // Counter for the number of button clicks

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;

        // Create the "Click Me" button
        Button btnClickMe = new Button();
        btnClickMe.setText("Click me please!");
        btnClickMe.setOnAction(e -> btnClickMe_Click()); // Event handler for button click

        // Create the "Close" button
        Button btnClose = new Button();
        btnClose.setText("Close");
        btnClose.setOnAction(e -> btnClose_Click()); // Event handler for close button

        // Add the buttons to a layout pane
        VBox pane = new VBox(10); // Vertical box layout with spacing of 10 pixels
        pane.getChildren().addAll(btnClickMe, btnClose); // Add buttons to the pane
        pane.setAlignment(Pos.CENTER); // Center align the buttons

        // Add the layout pane to a scene
        Scene scene = new Scene(pane, 250, 150); // Create a scene with specified width and height

        // Finish and show the stage
        primaryStage.setScene(scene); // Set the scene for the primary stage
        primaryStage.setTitle("Click Counter"); // Set the title of the window
        primaryStage.setOnCloseRequest(e -> {
            e.consume(); // Consume the event to prevent the application from closing
            btnClose_Click(); // Call close button click handler
        });
        primaryStage.show(); // Show the stage
    }

    // Handler for "Click Me" button
    public void btnClickMe_Click() {
        iClickCount++; // Increment the click counter
        // Create an alert showing the number of clicks
        Alert a;
        if (iClickCount == 1) {
            a = new Alert(Alert.AlertType.INFORMATION, "You have clicked once.");
        } else {
            a = new Alert(Alert.AlertType.INFORMATION, "You have clicked " + iClickCount + " times.");
        }
        a.showAndWait(); // Show the alert and wait for the user to close it
    }

    // Handler for "Close" button
    public void btnClose_Click() {
        // Create a confirmation alert before closing
        Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to quit?", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> confirm = a.showAndWait(); // Show the alert and wait for user response
        // Check if the user confirmed to close the application
        if (confirm.isPresent() && confirm.get() == ButtonType.YES) {
            stage.close(); // Close the application if user clicks YES
        }
    }
}
