package sia.book6.chapter4_LayoutPanes;

//BorderPane with a vertical column of buttons centered within it, you can set up a VBox containing the
// buttons and add it to the center of the BorderPane

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BorderPaneExample extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Create the buttons
        Button btn1 = new Button("Button One");
        Button btn2 = new Button("Button Two");
        Button btn3 = new Button("Button Three");

        // Create a VBox layout to arrange the buttons vertically
        VBox vbox = new VBox(10, btn1, btn2, btn3); // 10px spacing between buttons

        // Create a BorderPane and set the VBox in the center
        BorderPane pane = new BorderPane();
        pane.setCenter(vbox);

        // Create the scene with the BorderPane as the root node
        Scene scene = new Scene(pane, 400, 300);

        // Set up the stage
        primaryStage.setTitle("BorderPane Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

