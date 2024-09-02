module org.example.calcfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.calcfx to javafx.fxml;
    exports org.example.calcfx;
    exports org.example.calcfx.service;
    opens org.example.calcfx.service to javafx.fxml;
}