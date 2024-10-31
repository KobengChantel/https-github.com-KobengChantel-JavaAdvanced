package sia.book6.chapter4_LayoutPanes;
//code sets up a FlowPane layout with a
// horizontal orientation and spacing of 10 pixels between elements. The FlowPane will wrap the buttons to the next row if the total width exceeds 300 pixels
// as defined by setPrefWrapLength(300).


import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class FlowPaneLayoutExample extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Create the buttons
        Button btn1 = new Button("Button One");
        Button btn2 = new Button("Button Two");
        Button btn3 = new Button("Button Three");
        Button btn4 = new Button("Button Four");
        Button btn5 = new Button("Button Five");

        // Create a FlowPane with horizontal orientation and 10px spacing
        FlowPane pane = new FlowPane(Orientation.HORIZONTAL, 10, 10, btn1, btn2, btn3, btn4, btn5);
        pane.setPrefWrapLength(300); // Wrap to next row when width exceeds 300px

        // Create the scene with the FlowPane as the root node
        Scene scene = new Scene(pane, 400, 200);

        // Set up the stage
        primaryStage.setTitle("FlowPane Layout Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

