package sia.book6.chapter4_LayoutPanes;
////HBOX SPACER
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class HBoxLayoutWithSpacer extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Create the buttons
        Button btn1 = new Button("One");
        Button btn2 = new Button("Two");
        Button btn3 = new Button("Three");
        //set action
        btn2.setOnAction(e -> btn2_Click());
        // Create the spacer
        Region spacer = new Region();

        // Create the HBox layout pane with spacing of 10 pixels
        HBox hbox = new HBox(10, btn1, btn2, spacer, btn3);

        // Set margins for the buttons
        HBox.setMargin(btn1, new Insets(10));
        HBox.setMargin(btn2, new Insets(10));
        HBox.setMargin(btn3, new Insets(10));

        // Set the Hgrow for the spacer to push the third button to the right
        HBox.setHgrow(spacer, Priority.ALWAYS);

        // Create a scene and set it on the stage
        Scene scene = new Scene(hbox, 400, 100);
        primaryStage.setTitle("HBox Layout with Spacer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    //method to hanlde button
    private void btn2_Click () {
        System.out.println("Welcome to coding :) :)");
    }

    public static void main(String[] args) {
        launch(args);
    }
}

