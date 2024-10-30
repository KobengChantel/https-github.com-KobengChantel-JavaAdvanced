package sia.javafx.chapter2_HandlingEvents;
//listing 2.4
//The AddSubtract4 Program with Lambda Expressions
//Using Lambda Expressions
//to Handle Events
//Lambda expression lets
//you create an anonymous class that implements a specific type of interface — a
//functional interface — which has one and only one abstract method

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AddSubtract4 extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }
    Button btnAdd;
    Button btnSubtract;

    Label lbl;
    int iCounter = 0;
    @Override public void start(Stage primaryStage)
    {
// Create the Add button
        btnAdd = new Button();
        btnAdd.setText("Add");
        btnAdd.setOnAction( e ->
        {
            iCounter++;
            lbl.setText(Integer.toString(iCounter));
        } );
// Create the Subtract button
        btnSubtract = new Button();
        btnSubtract.setText("Subtract");
        btnSubtract.setOnAction( e ->
        {
            iCounter--;
            lbl.setText(Integer.toString(iCounter));
        } );
// Create the Label
        lbl = new Label();
        lbl.setText(Integer.toString(iCounter));
// Add the buttons and label to an HBox pane
        HBox pane = new HBox(10);
        pane.getChildren().addAll(lbl, btnAdd, btnSubtract);
// Add the layout pane to a scene
        Scene scene = new Scene(pane, 200, 75);
// Add the scene to the stage, set the title
// and show the stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Add/Sub");
        primaryStage.show();
    }
}