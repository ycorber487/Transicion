module com.example.transicion {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.transicion to javafx.fxml;
    exports com.example.transicion;
}