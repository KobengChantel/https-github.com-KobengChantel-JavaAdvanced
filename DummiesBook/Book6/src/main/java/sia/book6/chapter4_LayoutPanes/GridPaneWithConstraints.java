package sia.book6.chapter4_LayoutPanes;
//ridPane with specific column constraints where each column takes up 33% of the
// available width, you can use ColumnConstraints
//GridPane with three equally spaced columns, each constrained to 33% of the width
//GridPaneWithConstraints




   import javafx.application.Application;
import javafx.scene.Scene;
   import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GridPaneWithConstraints extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Create column constraints
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(33); // Set column 1 to 33% width

        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(33); // Set column 2 to 33% width

        ColumnConstraints col3 = new ColumnConstraints();
        col3.setPercentWidth(33); // Set column 3 to 33% width

        // Create a GridPane layout and add column constraints
        GridPane grid = new GridPane();
        grid.getColumnConstraints().addAll(col1, col2, col3);
        grid.setHgap(10); // Set horizontal gap between columns
        grid.setVgap(10); // Set vertical gap between rows

        // Create labels and text fields
        Label lblName = new Label("Name");
        TextField txtName = new TextField();

        Label lblEmail = new Label("Email");
        TextField txtEmail = new TextField();

        Label lblPhone = new Label("Phone");
        TextField txtPhone = new TextField();

        // Create buttons
        Button btnSubmit = new Button("Submit");
        Button btnCancel = new Button("Cancel");

        // Set action for Submit button
        btnSubmit.setOnAction(e -> {
            // Print the values from the text fields to the console
            System.out.println("Submitted Information:");
            System.out.println("Name: " + txtName.getText());
            System.out.println("Email: " + txtEmail.getText());
            System.out.println("Phone: " + txtPhone.getText());
        });

        // Set action for Cancel button
//        btnCancel.setOnAction(e -> {
//            // Clear the text fields
//            txtName.clear();
//            txtEmail.clear();
//            txtPhone.clear();
//        });

        // Set action for Cancel button to exit the program
        btnCancel.setOnAction(e -> {
            System.exit(0); // Terminate the application
        });

        // Add components to the GridPane
        grid.add(lblName, 0, 0);  // Column 0, Row 0
        grid.add(txtName, 0, 1);  // Column 0, Row 1
        grid.add(lblEmail, 1, 0); // Column 1, Row 0
        grid.add(txtEmail, 1, 1); // Column 1, Row 1
        grid.add(lblPhone, 2, 0); // Column 2, Row 0
        grid.add(txtPhone, 2, 1); // Column 2, Row 1


        // Add buttons to the GridPane
        grid.add(btnSubmit, 1, 2); // Column 1, Row 2
        grid.add(btnCancel, 2, 2); // Column 2, Row 2

        // Create the scene with the GridPane as the root node
        Scene scene = new Scene(grid, 400, 200);

        // Set up the stage
        primaryStage.setTitle("GridPane with Buttons Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}