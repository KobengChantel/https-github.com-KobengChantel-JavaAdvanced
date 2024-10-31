package sia.book6.chapter4_LayoutPanes;
//OnAction event for a button (btnCancel) and creating an
// HBox layout pane to hold two buttons, btnOK and btnCancel



//HBOX ARRANGES NODES HORIZONTALLY

    import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class OnAction extends Application {

        @Override
        public void start(Stage primaryStage) {
            // Create buttons
            Button btnOK = new Button("OK");
            Button btnCancel = new Button("Cancel");
            Button btnBack = new Button("Back");

            // Set action for btnCancel
//            btnCancel.setOnAction(e -> btnCancel_Click());
            btnBack.setOnAction(e -> btnBack_Click());

            // Create HBox and add buttons
            HBox pane = new HBox();
            pane.setSpacing(10); // Set spacing between elements in the HBox
            //addding buttons
            pane.getChildren().addAll(btnOK, btnCancel, btnBack);

            // Create scene and set the stage
            Scene scene = new Scene(pane, 300, 400);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Button Example");
            primaryStage.show();
        }

    // Method to handle back button click
    private void btnBack_Click() {
        System.out.println("Back button clicked!");
    }

    // Method to handle cancel button click
//        private void btnCancel_Click() {
//            System.out.println("Cancel button clicked!");
//
//        }

        public static void main(String[] args) {
            launch(args);
        }
    }


