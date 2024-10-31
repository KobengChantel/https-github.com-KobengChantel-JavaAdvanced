package sia.book6.chapter6_ChooosingFromList;
//choice box
import javafx.application.Application; // Import Application class for JavaFX
import javafx.scene.Scene; // Import Scene class for GUI setup
import javafx.scene.control.Alert; // Import Alert class for displaying messages
import javafx.scene.control.Button; // Import Button class for actions
import javafx.scene.control.ChoiceBox; // Import ChoiceBox class for selection
import javafx.scene.layout.VBox; // Import VBox for layout management
import javafx.stage.Stage; // Import Stage class for window management

public class ChoiceBoxExample extends Application {

    public static void main(String[] args) {
        launch(args); // Launch the JavaFX application
    }

    @Override
    public void start(Stage primaryStage) {
        // Create a ChoiceBox and add items to it
        ChoiceBox<String> choice = new ChoiceBox<>();
        choice.getItems().addAll("Bashful", "Doc", "Dopey", "Grumpy", "Happy", "Sleepy", "Sneezy");

        // Create a button to confirm the selection
        Button btnSelect = new Button("Select Character");
        btnSelect.setOnAction(e -> showSelectedCharacter(choice.getValue())); // Use getValue() to retrieve the selected item

        // Create a VBox layout to arrange the ChoiceBox and button vertically
        VBox pane = new VBox(10, choice, btnSelect);
        Scene scene = new Scene(pane, 300, 150); // Create a scene with the layout

        primaryStage.setTitle("ChoiceBox Example"); // Set the window title
        primaryStage.setScene(scene); // Set the scene to the primary stage
        primaryStage.show(); // Display the stage
    }

    /**
     * Method to show an alert with the selected character.
     *
     * @param selectedCharacter The selected character from the ChoiceBox.
     */
    private void showSelectedCharacter(String selectedCharacter) {
        String msg;
        if (selectedCharacter != null) {
            msg = "You selected: " + selectedCharacter; // Create message with selected character
        } else {
            msg = "No character selected."; // Message if nothing is selected
        }

        // Create an alert to display the selected character
        Alert alert = new Alert(Alert.AlertType.INFORMATION, msg);
        alert.setTitle("Selected Character"); // Set the title for the alert
        alert.showAndWait(); // Show the alert and wait for user response
    }
}
