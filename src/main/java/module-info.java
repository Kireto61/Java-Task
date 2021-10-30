module com.example.romancalculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.romancalculator to javafx.fxml;
    exports com.example.romancalculator;
}