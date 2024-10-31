package sia.book6.chapter4_LayoutPanes;
//COMBINING VBox AND HBox LAYOUTS
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ButtonLayoutExample extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Create a BorderPane and add the HBox and VBox
        BorderPane borderPane = new BorderPane();
        borderPane.setBottom(createBottomHBox()); // Place the HBox at the bottom
        borderPane.setRight(createRightVBox());   // Place the VBox on the right

        // Create the scene with the BorderPane as the root node
        Scene scene = new Scene(borderPane, 400, 300);

        primaryStage.setTitle("Button Layout Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Method to create and return an HBox with buttons for the bottom row
    private HBox createBottomHBox() {
        Button btnBottom1 = new Button("Bottom 1");
        Button btnBottom2 = new Button("Bottom 2");
        Button btnBottom3 = new Button("Bottom 3");

        HBox bottomHBox = new HBox(10, btnBottom1, btnBottom2, btnBottom3); // spacing of 10 pixels
        bottomHBox.setSpacing(10);
        return bottomHBox;
    }

    // Method to create and return a VBox with buttons for the right column
    private VBox createRightVBox() {
        Button btnRight1 = new Button("Right 1");
        Button btnRight2 = new Button("Right 2");
        Button btnRight3 = new Button("Right 3");

        VBox rightVBox = new VBox(10, btnRight1, btnRight2, btnRight3); // spacing of 10 pixels
        rightVBox.setSpacing(10);
        return rightVBox;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
