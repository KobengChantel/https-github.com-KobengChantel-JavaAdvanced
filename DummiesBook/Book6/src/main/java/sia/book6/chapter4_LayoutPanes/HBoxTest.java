package sia.book6.chapter4_LayoutPanes;
//Hb0x layout

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class HBoxTest extends Application {
//   @Override
   public void start (Stage primaryStage) {
       // creating new buttons
       Button btnCode = new Button("Code");
   Button btnContent = new Button("Contents");
   Button btnTitle = new Button("Title");

   //set action
       btnCode.setOnAction(e -> btnCode_Click());

       //creating hbox box
       HBox pane = new HBox();
       pane.setSpacing(20);
       //adding buttons
       pane.getChildren().addAll(btnCode, btnContent, btnTitle);

       //creatinng a scene stage
       Scene scene = new Scene(pane,  400, 400);
       primaryStage.setScene(scene);
       primaryStage.setTitle("Heeelo Java");
       primaryStage.show();
   }

   //method to handle the button
    private void btnCode_Click() {
       System.out.println("Welcome to coding :) :)");
    }
    public static void main(String[] args){
       launch(args);
    }
}
