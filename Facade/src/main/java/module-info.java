module com.example.facade {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.facade to javafx.fxml;
    exports com.example.facade;
}