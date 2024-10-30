package sia.book6.chapter1_JavaFX;
//listing 6.1
//ser interface for a very simple JavaFX program that includes
//just a single button.

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
public class ClickMe extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }
    Button btn;
    @Override public void start(Stage primaryStage)
    {
// Create the button

        btn = new Button();
        btn.setText("Click me please!");
        btn.setOnAction(e -> buttonClick());
// Add the button to a layout pane
        BorderPane pane = new BorderPane();
        pane.setCenter(btn);
// Add the layout pane to a scene
        Scene scene = new Scene(pane, 300, 250);
// Finalize and show the stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("The Click Me App");
        primaryStage.show();
    }
    public void buttonClick()
    {
        if (btn.getText() == "Click me please!")
        {
            btn.setText("You clicked me!");
        }
        else
        {
            btn.setText("Click me please!");
        }
    }
}