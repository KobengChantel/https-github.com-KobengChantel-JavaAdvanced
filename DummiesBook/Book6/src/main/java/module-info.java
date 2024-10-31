//module sia.book6 {
//    requires javafx.controls;
//    requires javafx.fxml;
//    requires javafx.web;
//
//    requires org.controlsfx.controls;
//    requires com.dlsc.formsfx;
//    requires net.synedra.validatorfx;
//    requires org.kordamp.ikonli.javafx;
//    requires org.kordamp.bootstrapfx.core;
////    requires eu.hansolo.tilesfx;
//    requires com.almasb.fxgl.all;
//
//    opens sia.book6 to javafx.fxml;
//    exports sia.book6;
//}

module sia.book6 {
        requires javafx.controls;
        requires javafx.graphics;
        requires javafx.fxml;
        requires javafx.web;
        requires org.controlsfx.controls;
        requires com.dlsc.formsfx;
        requires net.synedra.validatorfx;
        requires org.kordamp.ikonli.javafx;
        requires org.kordamp.bootstrapfx.core;
        requires com.almasb.fxgl.all;

        // Allow JavaFX to access the classes within these packages
        exports sia.book6 to javafx.graphics;
        exports sia.book6.chapter1 to javafx.graphics;
        exports sia.book6.chapter1_JavaFX to javafx.graphics;
        exports sia.book6.chapter2_HandlingEvents to javafx.graphics;
        exports sia.book6.chapter3_SettingStageAndScene to javafx.graphics;
        exports sia.book6.chapter4_LayoutPanes to javafx.graphics;
        exports sia.book6.chapter5_GettingInputFromUser to javafx.graphics;
        exports sia.book6.chapter6_ChooosingFromList to javafx.graphics;



        // Allow reflective access to javafx.fxml
        opens sia.book6 to javafx.fxml;
        }
