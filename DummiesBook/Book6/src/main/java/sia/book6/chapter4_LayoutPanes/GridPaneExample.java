package sia.book6.chapter4_LayoutPanes;
//GridPane layout that includes a label (lblName)
// and a text field (txtName) in the first row, you can use the GridPane layout, which allows you to
// arrange components in a grid of rows and columns

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GridPaneExample extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Create a label and a text field
        Label lblName = new Label("Name");
        TextField txtName = new TextField();

        // Create a GridPane layout
        GridPane grid = new GridPane();
        grid.setHgap(10); // Set horizontal gap between columns
        grid.setVgap(10); // Set vertical gap between rows
        grid.addRow(0, lblName, txtName); // Add label and text field to row 0

        // Create the scene with the GridPane as the root node
        Scene scene = new Scene(grid, 300, 200);

        // Set up the stage
        primaryStage.setTitle("GridPane Layout Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

