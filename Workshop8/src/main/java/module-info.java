module com.himanshu.workshop8 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.himanshu.workshop8 to javafx.fxml;
    exports com.himanshu.workshop8;
}